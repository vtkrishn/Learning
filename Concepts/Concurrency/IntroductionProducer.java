class producer extends Thread{
	Buffer q;
	producer(Buffer q){
		this.q = q;
	}

 void run(){
 	q.put();
 }

}

class cosumer extends Thread{
	Buffer q;
	cosumer(Buffer q){
		this.q = q;
	}

 void run(){
 	q.get();
 }

}

class Buffer{
	Lock lock = new Lock();

	void put(){
		lock.lock();
			while(g == length){

			}
		lock.unlock();
	}

	void get(){
		lock.lock();
			while(g == length){
				
			}
		lock.unlock();
	}

}
