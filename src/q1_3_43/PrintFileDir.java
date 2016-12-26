package q1_3_43;

import java.io.File;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PrintFileDir {
	
	private static class FileStructure {

		private int fileLevel;
		private File file;
		public FileStructure(File file, int fileLevel) {
			this.file = file;
			this.fileLevel = fileLevel;
		}
		
		public File getFile() { return file; }
		
		public int getFileLevel() { return fileLevel; }
	}
	
	public static void main(String[] args) {
		String rootFilePath = StdIn.readString();
		File rootFile = new File(rootFilePath);
		if(!rootFile.exists()) return;
		FileStructure rootFileStructure = new FileStructure(rootFile, 0);
		Stack<FileStructure> stack = new Stack<>();
		stack.push(rootFileStructure);
		while(!stack.isEmpty()) {
			FileStructure fileStructure = stack.pop();
			for(int i = 0; i < fileStructure.getFileLevel(); i++) {
				StdOut.print("\t");
			}
			StdOut.println(fileStructure.getFile().getName());
			if(fileStructure.getFile().isDirectory()) {
				File[] files = fileStructure.getFile().listFiles();
				for(File pushFile : files) {
					FileStructure pushStructure = new FileStructure(pushFile, fileStructure.getFileLevel()+1);
					stack.push(pushStructure);
				}
			}
		}
	}
}
