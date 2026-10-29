package com.marmin.app;

class Gardeners{

    private Gardener[] gardeners=new Gardener[0];

    private int count;

    public Gardeners(){}

     public Gardener getGardener(int index){
        return gardeners[index];
    }

    public int getLength(){
        return gardeners.length;
    }


 
    public void addGardeners(Gardener obj){
        
        for(int i=0;i<gardeners.length;i++){
            if(gardeners[i].getID()==obj.getID()){
                  throw new IllegalArgumentException("ID Exist");
            }
        }
        if(obj.getID()<0||obj.getName().isBlank()){
            throw new IllegalArgumentException("Provide valid arguments");
        }
        if(count==gardeners.length){
            int newcapacity=gardeners.length+1;
            Gardener[] newGardeners=new Gardener[newcapacity];
            for(int i=0;i<count;i++){
                newGardeners[i]=gardeners[i];
            }
            gardeners=newGardeners;
            
        }
        gardeners[count++]=obj;
    }

    

}

