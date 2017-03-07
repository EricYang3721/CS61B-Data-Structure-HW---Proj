/* ListSorts.java */

import list.*;


public class ListSorts {

  private final static int SORTSIZE = 100;
  //LinkedQuene que;
  //private LinkedQueue q;
  
  
  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.	
	LinkedQueue qOfQs = new LinkedQueue();
	//System.out.println(q.size());
	int iteration = q.size();
	try{
		for(int i = 0; i < iteration;i++){
			Object item = q.dequeue();
			LinkedQueue tempQ = new LinkedQueue();
			tempQ.enqueue(item);
			qOfQs.enqueue(tempQ);
			//System.out.println(i);
		}
	} catch(QueueEmptyException e){
			System.out.println("Queue is Empty!");			
		}

	
	//System.out.println(qOfQs);
    return qOfQs;
  }
  


  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
	LinkedQueue result = new LinkedQueue();
	if(q1.size() <= q2.size()){
		LinkedQueue temp = q2;
		q2 = q1;
		q1 = temp;
	}
	//int q1_num = q1.size();
	//int q2_num = q2.size();
	try{
		
		while(!q1.isEmpty() && !q2.isEmpty()){
			Integer q1Comp = new Integer((int)q1.front());
			Integer q2Comp = new Integer((int)q2.front());
			if(q1Comp.compareTo(q2Comp)<=0){
				result.enqueue(q1.dequeue());
			} else {
				result.enqueue(q2.dequeue());
			}
		}
		while(!q1.isEmpty()){
			result.enqueue(q1.dequeue());
		}
		while(!q2.isEmpty()){
			result.enqueue(q2.dequeue());
		}		
			
	} catch(QueueEmptyException e){
			System.out.println("Queue is Empty!");			
		}
	
	//System.out.println(result);
    return result;
  }

  /*public static int compare(Object obj1, Object obj2){
	  int p1 = (int) obj1;
	  int p2 = (int) obj2;
	  return p1-p2;
  }*/

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
	try{
		while(!qIn.isEmpty()){
			Object item = qIn.dequeue();
			int temp = pivot.compareTo((Comparable)item);
			if(temp > 0) qSmall.enqueue(item); 
			else if(temp == 0) qEquals.enqueue(item);
			else qLarge.enqueue(item);
		}
	} catch(QueueEmptyException e){
		System.out.println(e);
	}
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
	int iterations = q.size()-1;
	LinkedQueue qoq = makeQueueOfQueues(q);
	
	//System.out.println(qoq);
	LinkedQueue q1;
	LinkedQueue q2;
	
	//System.out.println(iterations);
	try{
		while(iterations > 0){
			q1= (LinkedQueue) qoq.dequeue();
			//System.out.println(qoq.dequeue());
			q2= (LinkedQueue) qoq.dequeue();
			LinkedQueue mergedQ = mergeSortedQueues(q1,q2);
			
			qoq.enqueue(mergedQ);
			iterations--;
			
		}
		q.append((LinkedQueue) qoq.dequeue());
		//System.out.println(qoq);
		//System.out.println(q);
	} catch(QueueEmptyException e){
		System.out.println("Merge Sort error");
	}
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
	if(q.size()<2){
		return;
	}
	int n = (int)Math.random()*q.size();
	Comparable pivot = (Comparable)q.nth(n);
	LinkedQueue qSmall = new LinkedQueue();
	LinkedQueue qEquals = new LinkedQueue();
	LinkedQueue qLarge = new LinkedQueue();
	partition(q, pivot, qSmall, qEquals, qLarge);
	quickSort(qSmall);
	quickSort(qLarge);
	q.append(qSmall);
	q.append(qEquals);
	q.append(qLarge);
	

  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());
	
    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());

    //Remove these comments for Part III.
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    
  }

}
