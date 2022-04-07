package softwaredesign.metrics;

public class Speed extends Metrics {

     public Speed(Double Distance , Double Time){
         this.name = "SPEED";
         CalculateSpeed(Distance,Time);
     }

     public  void CalculateSpeed(Double dis , Double time){
        this.value = dis/time;
     }

}
