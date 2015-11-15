/**
 * 
 */
package deb.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class FileAndDirectoryInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter file or directory name :");
			
			Path path = Paths.get(input.nextLine());
			
			if (Files.exists(path)){
				// display file (or directory) information
				System.out.printf("%n%s exists%n",path.getFileName());
				
				if (Files.isDirectory(path)){
					DirectoryStream<Path> directoryStream;
					try {
						directoryStream = Files.newDirectoryStream(path);
						for (Path p: directoryStream) {
							System.out.println(p+ "  size " + Files.size(p));
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			} else {
				System.out.printf("%s does not exist%n", path);
			}
		}

	}

}
