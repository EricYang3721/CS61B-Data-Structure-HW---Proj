/* ListSorts.java */

import list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000;
  //LinkedQuene que;
  
  
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

	
	System.out.println(qOfQs);
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
	try{
		Comparator item1 = (Comparator)q1.dequeue();
		Comparator item2 = (Comparator)q2.dequeue();
		for(int i=0; i<q1.size(); i++){
			if(item1.compareTo(item2)<=0 || i>=q2.size()){
				result.enqueue(item1);
				item1 = (Comparator)q1.dequeue();
			} else {
				result.enqueue(item2);
				item2 = (Comparator)q2.dequeue();
			}
		}
			
	} catch(QueueEmptyException e){
			System.out.println("Queue is Empty!");			
		}
	
	System.out.println(result);
    return result;
  }


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
	
	System.out.println(iterations);
	try{
		while(iterations > 0){
			q1= (LinkedQueue) qoq.dequeue();
			//System.out.println(qoq.dequeue());
			q2= (LinkedQueue) qoq.dequeue();
			LinkedQueue mergedQ = mergeSortedQueues(q1,q2);
			
			qoq.enqueue(mergedQ);
			iterations--;
		}
		
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
    //System.out.println(q.toString());
	/*
    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());*/

    /* Remove these comments for Part III.
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
    */
  }

}
