//define the Queue interface 
public interface Queue<E>{

//the below method is used to add new elements to the queue
void addData(double number);
//the below method is used to evalutae the simple moving average
double calculateSimpleMovingAverage();
}

//The below class implements the Queue interface to determine the moving average
public class QueueImplementation implements Queue<T>{

//we define a queue data structure to store the list
private final Queue<Double> dataList=new LinkedList<Double>();

//the below variable is the count of numbers for which the average is to be determined
private int numberOfDigits=0;

//the below variable is sed to calculate the sum of the numbers in the queue
private int sum;

//constructor
public QueueImplementation(int numberOfDigits){
  this.numberOfDigits=numberOfDigits;
}

@Override
public void addData(double number){
  sum+=number;
  dataList.add(number);
  if(dataList.size()>numberOfDigits){
    sum-=dataList.remove();
  }
}

@Override
public double calculateSimpleMovingAverage(){
  return sum/numberOfDigits;
}
}

//The below Junit class is used to test the above code.
public class QueueImplementationTest{
  private QueueImplementation queueImplementation;
  @Test
  public void testCalculateSimpleMovingAverage(){
    double[] input={1,2,3,4,5};
    queueImplementation = new QueueImplementation(3);
    for(double x:input){
      queueImplementation.addData(x);
    }
    Assert.assertEquals(4.0,queueImplementation.calculateSimpleMovingAverage(),0);
  }
}
