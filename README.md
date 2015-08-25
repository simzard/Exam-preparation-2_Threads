# Exam-preparation-2_Threads
Answer to question 4 in SP1 handin

**Question**: When and why will we use Threads in our programs?

**Answer**:	when we want to do more things at the same time without blocking the CPU resources - 
	        more specifically:
- make the UI more responsive
- take advantage of multiprocessor systems
- simplify modeling
- perform asynchronous or background processing
		

**Question**: Explain about the Race Condition Problem and ways to solve it in Java.

**Answer**:	A race condition occurs, when a system attempts to perform two or more operations at the same time,
but because of the nature of the device or system, the operations must be done in the proper sequence to be done correctly.

In Java, it can be solved by using the keywords volatile (for primitives) and synchronized blocks and/or methods.      Thus utilizing locks, so that an object can only be accessed by ONE thread at a time.
	
Another solution could be, that a thread should wait untill the other thread is done by using Thread.join()
	
(we never know wich thread is gonna get executed first - that's the responsibility of the OS)

**Question**: Explain how Threads can help us in making responsive User Interfaces

**Answer**: Without additional helper threads, if an event listener would perform a lengthy task, it would freeze the system untill it would be done with the task.

If a thread handles UI events such as input from the user (keyboard, mouse, etc.), another thread doesn't need to bother with that.
Event-driven UI toolkits, such as AWT and Swing, have an event thread that processes UI events such
as keystrokes and mouse clicks.
AWT and Swing programs attach event listeners to UI objects. These listeners are notified when a 	  specific event occurs, such as being clicked. When the click event is activated and sent to the handler, we just start a thread from
the handler to carry out the heavy/blocky computations.

**Question**: Explain how we can write reusable non-blocking Java Controls using Threads and the observer Pattern

**Answer**:
( Practical part )

When we run the code in the program and press the button, everything else freezes until the button has completed its task.

**Solution**:

1. make the RandomUserControl a SUBJECT - i.e. it has to extend Observable
2. make the RandomUserForm an Observer - i.e. it has to implement the Observer interface
3. in RandomUserControl:
	change the fetchRandomUser to return void and add the lines setChanged() and notifyObservers(user)
	-> this means that every time this method is called, the Observers who are following this object
		will get notified (setChanged() just means that SOMETHING NEW is afoot! )
4. in RadomUserForm add an Inner Class which implements Runnable which should be responsible of the Work 		Duty in run
	in update(Obeservable o, Object arg) update the text fields there
	
	(now we have a thread started every time, we click on the button instead of blocking up the UI)
