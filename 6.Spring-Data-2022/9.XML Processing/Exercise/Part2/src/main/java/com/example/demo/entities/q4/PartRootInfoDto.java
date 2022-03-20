package com.example.demo.entities.q4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRootInfoDto {

    @XmlElement(name = "part")
    List<PartInfoDto> parts;

    public PartRootInfoDto() {
    }

    public List<PartInfoDto> getParts() {
        return parts;
    }

    public void setParts(List<PartInfoDto> parts) {
        this.parts = parts;
    }
}
