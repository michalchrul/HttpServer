package scc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;

@Cacheable(value="crib")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Crib implements Serializable {

    private static final long serialVersionUID = 7156526077883281723L;

    int cribCode;
    String babyName;
    float temperature;
    bool isBabyAwake;
    int rockingSpeed;
    int toySpeed;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCribCode() {
        return cribCode;
    }

    public void setCribCode(int cribCode) {
        this.cribCode = cribCode;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public bool getIsBabyAwake() {
        return isBabyAwake;
    }

    public void setIsBabyAwake(bool isBabyAwake) {
        this.isBabyAwake = isBabyAwake;
    }

    public int getRockingSpeed() {
        return rockingSpeed;
    }

    public void setRockingSpeed(int rockingSpeed) {
        this.rockingSpeed = rockingSpeed;
    }

    public int getToySpeed() {
        return toySpeed;
    }

    public void setToySpeed(int toySpeed) {
        this.toySpeed = toySpeed;
    }


}
