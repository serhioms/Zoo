package rd.mss.util.tail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class UnTail {

	static byte[] buffer = new byte[1000000];

	public static String TAIL_MARKER = "pspdpfpgphpjpkpl";
	
	static String HEADER_MARKER = "PK";
	static byte[] TAIL_MARKER_BYTES = stringToBytesASCII(TAIL_MARKER);
	static byte[] HEADER_MARKER_BYTES = stringToBytesASCII(HEADER_MARKER);
	static int HEADER_MARKER_INT = HEADER_MARKER.length();
	static int TAIL_MARKER_INT = TAIL_MARKER.length();
	
	static String BASE_FOLDER = null;

	public static void main(String[] args) throws IOException {
		String picFilePath = args.length > 0 && !"null".equals(args[0])? args[0]: throwFileNotFoundException();
		File picFile = new File(picFilePath);
		
		BASE_FOLDER = picFile.getParentFile().getAbsolutePath();
		String picFileName = picFile.getName();
		
		untail(picFileName, picFileName + ".zip", BASE_FOLDER);
	}

	private static String throwFileNotFoundException() {
		throw new RuntimeException("Input picture not specified!");
	}

	public static void tail(String picsrc, String tailsrc, String dest, String basefolder) throws IOException {

		int picsize = read(basefolder + File.separator + picsrc, 0, 0);
		System.out.printf("Pic size = %d\n", picsize);
		
		for(int i=0,max=TAIL_MARKER_BYTES.length; i<max; i++) {
			buffer[picsize+i] = TAIL_MARKER_BYTES[i];
		}
		picsize += TAIL_MARKER_BYTES.length;

		
		int zipsize = read(basefolder + File.separator + tailsrc, picsize, HEADER_MARKER_INT);
		System.out.printf("Zip size = %d\n", zipsize);

		int totalsize = picsize + zipsize;
		System.out.printf("Total = %d < %d\n", totalsize, buffer.length);

		write(basefolder + File.separator + dest, 0, totalsize);
	}
	
	public static void untail(String srcfile, String outfile, String basefolder) throws IOException {
		int totalsize = read(basefolder + File.separator + srcfile, 0);
		System.out.printf("Total = %d\n", totalsize);
		
		int mpos = findMarker(TAIL_MARKER_BYTES, 0, totalsize);
		System.out.printf("'%s' position = %d\n", TAIL_MARKER, mpos);

		mpos = findMarker(TAIL_MARKER_BYTES, 0, mpos);
		System.out.printf("'%s' position = %d\n", TAIL_MARKER, mpos);
		
		mpos = findMarker(TAIL_MARKER_BYTES, 0, mpos);
		System.out.printf("'%s' position = %d\n", HEADER_MARKER, mpos);


		write(basefolder + File.separator + outfile, mpos+TAIL_MARKER_INT, totalsize, HEADER_MARKER_BYTES);
	}
	
	private static int findMarker(byte[] marker, int start, int finish) {
		for (int i, p = finish - marker.length, maxi = marker.length; p > 0; p--) {
			for (i = 0; i < maxi; i++) {
				if (buffer[p + i] != marker[i]) {
					break;
				}
			}
			if( i == maxi ) {
				return p;
			}
		}

		return -1;
	}

	public static byte[] stringToBytesASCII(String str) {
		char[] buffer = str.toCharArray();
		byte[] b = new byte[buffer.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) buffer[i];
		}
		return b;
	}

	static void write(String fileName, int offset, int size) throws IOException {
		write(fileName, offset, size, null);
	}

	static void write(String fileName, int offset, int size, byte[] header) throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		try {
			if( header != null ) {
				stream.write(header);
			}
			stream.write(buffer, offset, size-offset);
		} finally {
			stream.flush();
			stream.close();
		}
	}

	static int read(String file, int offset, int skip) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		try {
			rf.seek(skip);
			return rf.read(buffer, offset, buffer.length - offset);
		} finally {
			rf.close();
		}
	}	
	
	static int read(String file, int offset) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		try {
			return rf.read(buffer, offset, buffer.length - offset);
		} finally {
			rf.close();
		}
	}
}