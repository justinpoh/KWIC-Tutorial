package com.company;

import java.util.ArrayList;
import java.util.List;

public class Pipe {
    private List<String> dataToTransfer;
    public void sendData(List<String> dataToSend){
        dataToTransfer = new ArrayList<String>(dataToSend);
    }
    public List<String> getData(){
        return dataToTransfer;
    }
}
