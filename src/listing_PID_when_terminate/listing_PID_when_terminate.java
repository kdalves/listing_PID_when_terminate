package listing_PID_when_terminate;

import java.io.IOException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class listing_PID_when_terminate {
	public static void main(String[] args) 
	      throws ExecutionException, InterruptedException, IOException
	   {
	      Process p = new ProcessBuilder("notepad.exe").start();
	      ProcessHandle ph = p.toHandle();
	      CompletableFuture<ProcessHandle> onExit = ph.onExit();
	      onExit.get();
	      onExit.thenAccept(ph_ -> System.out.printf("PID %d terminated%n", 
	                                                ph_.pid()));
	   }
}
