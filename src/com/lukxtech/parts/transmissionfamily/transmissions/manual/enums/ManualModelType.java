package com.lukxtech.parts.transmissionfamily.transmissions.manual.enums;

import com.lukxtech.parts.transmissionfamily.transmissions.manual.exceptions.InvalidManualModelTypeException;

public enum ManualModelType {
    MP4, MP5, MP6, MD5, MD6;

    public static ManualModelType fromString(String type){
        return switch (type.toLowerCase().trim()){
            case "mp4" -> MP4;
            case "mp5" -> MP5;
            case "mp6" -> MP6;
            case "md5" -> MD5;
            case "md6" -> MD6;
            default -> throw new InvalidManualModelTypeException("BAD MANUAL MODEL TYPE! GOT: " + type +"\nPERMISSIVE: mp4, mp5, mp6, md5, md6");
        };
    }
}
