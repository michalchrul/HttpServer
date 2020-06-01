package scc.ctrls;

import scc.dto.Post;
import com.google.gson.Gson;
import com.microsoft.azure.cosmosdb.Document;
import com.microsoft.azure.cosmosdb.FeedOptions;
import com.microsoft.azure.cosmosdb.FeedResponse;
import com.microsoft.azure.cosmosdb.ResourceResponse;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rx.Observable;

import java.util.*;

import static scc.ctrls.CosmosDb.getCollectionString;
import static scc.ctrls.CosmosDb.getDocumentClient;


@RestController
@RequestMapping("/crib")
public class PostCtrl {

    @PostMapping("/add")
    public ResponseEntity<String> addCrib(@RequestParam("cribCode") int cribCode,@RequestParam("babyName") String babyName,
                                          @RequestParam("temperature") float temperature,@RequestParam("isBabyAwake") boolean isBabyAwake,
                                          @RequestParam("rockingSpeed") int rockingSpeed,
                                          @RequestParam("toySpeed") int toySpeed){
        String addedCrib= "";



        Crib crib = new Crib();
        try {
            AsyncDocumentClient client = getDocumentClient();
            String UsersCollection = getCollectionString("Crib");

            crib.setCribCode(cribCode)
            crib.setBabyName(babyName);
            crib.setTemperature(temperature);
            crib.setIsBabyAwake(isBabyAwake);
            crib.setRockingSpeed(rockingSpeed);
            crib.setToySpeed(toySpeed);
            Observable<ResourceResponse<Document>> resp = client.createDocument(UsersCollection, crib, null, false);
            String str =  resp.toBlocking().first().getResource().getId();
            crib.setId(str);

            FeedOptions queryOptions = new FeedOptions();
            queryOptions.setEnableCrossPartitionQuery(true);
            queryOptions.setMaxDegreeOfParallelism(-1);

        } catch( Exception e) {
            e.printStackTrace();
        }
        String contentType = "application/json";

        Gson g = new Gson();
        addedCrib = g.toJson(post);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(addedCrib);
    }

}
