import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class PruebasJUnit {

	@Test
	void priorityQueueTest() {
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
		pQueue.add("C, Juan Perez, fractura de pierna");
		pQueue.add("A, Maria Ramirez, apendicitis");
		pQueue.add("E, Lorenzo Toledo, chikunguya");
		pQueue.add("B, Carmen Sarmientos, dolores de parto");
		
		if(!pQueue.isEmpty()) {
			assertEquals(pQueue.isEmpty(),true);
		}
	}
	
	@Test
	void vectorHeap() {
		VectorHeap<String> Heap = new VectorHeap<String>();
		Heap.add("C, Juan Perez, fractura de pierna");
		Heap.add("A, Maria Ramirez, apendicitis");
		Heap.add("E, Lorenzo Toledo, chikunguya");
		Heap.add("B, Carmen Sarmientos, dolores de parto");
		
		for (int i = 0; i< Heap.size(); i++) {
			String str[] = new String[Heap.size()];
			str = Heap.toString(Heap, Heap.size());
			//se ordena el heap
			str = Heap.sortS(str, Heap.size());
			
			Heap.vp(str, Heap.size(), Heap);
			
			if(!Heap.isEmpty()) {
				assertEquals(!Heap.isEmpty(),true);
			}
		}
	}

}
