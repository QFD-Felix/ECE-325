import java.util.*;
import java.math.BigInteger;
public class fnv {
//	uint64_t fnv(void *b, int c) {
//		unsigned char *p = b;
//		uint64_t h = 14695981039346656037;
//		int i;
//		for (i = 0; i < c; i++)
//			h = (h * 1099511628211) ^ p[i];
//		return h; }
//	
	public static BigInteger fnv1(char[]b, int c) {
		char[]p = Arrays.copyOf(b, b.length);
		BigInteger h = new BigInteger("14695981039346656037");
		for (int i = 0; i<c; i++) {
			h = h.multiply(new BigInteger("1099511628211")).xor(new BigInteger(String.valueOf(Character.getNumericValue(p[i]))));
			h = h.mod(new BigInteger("2").pow(64));
		}
		return h;
	}
	public static void main(String[] args) {
		char[] test = {'a', 'b', 'c', 'd', 'e', 'f'};
		System.out.println(fnv1(test,5));
	}
}
