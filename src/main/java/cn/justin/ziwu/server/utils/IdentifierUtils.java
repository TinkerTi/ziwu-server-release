package cn.justin.ziwu.server.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class IdentifierUtils {
	static private Logger LOGGER = LoggerFactory.getLogger(IdentifierUtils.class);
	static private ShortUuid.Builder SHORT_UUID_BUILDER = new ShortUuid.Builder();

	
	private static String indexTable = 
			"WPgeyRqt6k@2BKfhvHAcY7TMbOmUpi9oZaXzGswS13L=xdjFu4JEN5I0V8rnDlQC";

	private static final int[]  randLineOffset = {109, 6, 218, 162, 63, 207, 162, 194, 41, 145, 218};
	private static final int randLineOffsetSize = randLineOffset.length;
	
	private static String charTable[] = {
		"7YFvDCXbqGfuLczWJKVIUEQig6m3HnZS8A2j5er0@xwN1MPRd49=pkshoOlaTBty",
		"rxjOzdo4IHJbRL1twW9B0yk2mMFn@65NS8geAQ7svPuaDEhCGTKqZi=YpV3lcfXU",
		"HJsEAT9yq0dIBYueCrPo=mk8aL65RKwgWOjS1hxZiFMlvnDN4QG2bV@cp7UtfXz3",
		"CXp2tFDZ6gaKL@3Y=HUWu1rjEBQ54NPJRmefqcy0TdIsiAlSnG8hVbMkw79oxvzO",
		"ZLvbRy9sS8u@dWaIBh1lDpV=iTEkXUG5MOmqn47KP3wfNQ06zHrejYAgFxt2oJcC",
		"LzDIg=6CsFHTl9b84YxX1w5ah@Q0oieMnWVqfGRcUkPjmprKZJ2NOEd7v3uyBSAt",
		"TJhXdnFU1Lg67ycvr@E28zm3PHZNquf=Sbwoi5IWKBx0lCQaOsGktYAVMpeDRj49",
		"b6H4cF71zjTyivLPA2X@CD5OBYrQWpufn0UEK9MSJ=ade38oqNxIwZslhkmVgRtG",
		"OyGVokdHEtx9TCfJc7z6=Lns1BpeMrRhbN2lXPDi0U5SFqKA@mWawY4Ig3Z8vjuQ",
		"DTQKl4gAJmbLXSeR2Gh1iMfj7Cn93q=oF6upY5aHUZWr@cEvxBszt0dVwkOyNP8I",
		"wKLTzZinJeqAOfExh2kGuojBWsyb30PHm95UlCN61vFr8t@=XpVMga4cI7SRDQdY",
		"1fDRCrAuOvPc5@o4Ylqp6BjsNtxJdIXKZwkVzTH=h8e0FaQ92ngMyGiLWU7Sb3mE",
		"ZnGBPy1KUor3l8w9SVDNHYmFL6tICzsEg@OJvb7u2=4fqXk0QMRcTxdja5pWiehA",
		"mhkR01XfrL9v7GUjQuc3JtIFEdBlK=bOTyZpoCAwNa8Y2S6esWgM5zqPi@xnD4VH",
		"DbOoFEvzVnQA0eBCIt=RuY87aiy5jZgNP3sw@Sx96MKdcGTHJp2mUh4Wrfk1lqXL",
		"eyfjZ9Tu3=aF6KtGDvOg@hsEnWRqmLloc7p4AbXMzrdwix8YSCI15V20PUNJBkHQ",
		"@paPC9goz6TcGlAKDrnNLvhHqtZ0YFyk7Rmif38bJU5SWx4IEdBOuMsj1eXQVw2=",
		"uWNjH0ZDbiBeJQroVSXlh67Yn=xKaLyCfps@PzOUEtv4I15RqMTc38AGkd29mwgF",
		"mxSbdN23DWArikj5CXuGzhIav9qLV4fM7ePlQ6E1RUZnYO0F=yKBwo@8TJgspHtc",
		"sriUqTuhfQz1O63dKLPkcSZRJAEn5@gyelH9=wMtp87Vb4jBoXNm2GYx0DFvCIaW",
		"ExqNK5XsO@nmeZQPSL6y4ukdl2GBw=H8YMzjW7Jaofpvhcg10A9I3CFRTrtVbDUi",
		"T7neYGa9WAt1NS2ip@0sywHFOgQkzIKcf8m=Uj5CDVdlR3hovXq4uLJMxrbPEZ6B",
		"Pq4WTsgMwi0=CoKnVxGa6YF1m7HZ5@rJlNUdEhB8pItAQXfD3Rc2jyvL9SbzekuO",
		"fw0vlE1oKY2H9euxBVhzjyn=Isq3JgiQFP6O7pRTWSaGL@bZM8cC5mUkrt4NDXdA",
		"7P9i6=VBfWIs5r048Zk3SaAKpRutHczCjmLYwgUNeqXQo1nyxb2@dDlFMGTEhvJO",
		"QYFIT3lr2G49zqPkbZONepd06o5MXgun1RsaWxD7Vm=CjhEHtSUvKAJ@f8ycBLwi",
		"F7zspNyXKYIim=thW2QvGljLgM6ZfeVSb35PBkw@T0dOqU48D1AcRaErHCn9uxoJ",
		"5taXHj46O8qnGVhEBi0peA91x2r7YZvDyWmzUPTfMkbNRKlc=@CsLoFSQguw3IdJ",
		"ADo@J0HhkjGBFVQ5pIUReEOuiTKgSmwC1r94s2=zXnLW73fxPyacYNMZbtqd8vl6",
		"JLXN0Kd7sUqwtbmzl=hyDrpQoTIGMEiH5RZWf8u4cng32jBaPOFSvY6xeC91@AkV",
		"moL8p1yMA2DrzP=cSd7xJUQeR4s@OH60KwYbTGl5hF3IkEvjWCXuqN9ntiBVgaZf",
		"uqw3CvJYA4XdWnBaSHj6872lF1OpfyKmNZ9IGTh@EUPLMi50DegstxRzQVr=ocbk",
		"f78AUsz3j9lTowmZKL4GyOBPJFbIV0WC1nteEixXYp2S6QaHg@kMhRN=qruDvc5d",
		"RHYw7LQpcI5FgtkBvzUienT@Pjr3C=KJxbA1EoZaD80h2WdVNMmqS4XOsy6uG9fl",
		"dE0lv51pDL3SPqfyHBtGkT4jMYh6VWQRFi=snUK928ebmuC7xOaXJr@ZNcAozIgw",
		"i9bglw8eyn=106xd2KUoBCYjSshHk5vTVrO4qaJ3fIAWZ@XNGFp7PztuMQLcERmD",
		"u2L6hmbid8VnAf@PQFg=9jGtOsNTZoYIeazqlB1rxEw4HvSCW75yUp0cKMD3kXRJ",
		"NMpYbV8Py25UhJk0fgl4Lv3nsqDEA7ojKSzcuirHZ1mXxFRQGw=C9BOedT6aW@tI",
		"k8ngZBEyXseRKDqOH60Jov4pUbLh3t1V5IW29idYxlaCQfwNju7m@PTczFSrAM=G",
		"c1l37HrvL4GdBizRsfaFQ=mZ0kbUpIKqyTVX8g@6ewW5PuEYjOxSt2C9JNADnMho",
		"6dNo2WsP1jtz8BrQwXuG@KxcEHUVfAFJ0aL=I4CeyMYvgDpSOq9i3hlR5mZnkT7b",
		"m4ZvSLj70FB9WAKrOkgVhl5@8wdMscpxTioHIGeDqPuR2J1b36tXnUzaNYCQ=yfE",
		"OMdHNCVXb1fDYsvQrx2y7EtKgJUw@3Sc64Bi5zjhnqRl9G=akILoAFPe0W8uZTpm",
		"Sm8yonEpwBZWFuQfX0GYbks1LvxqMaIjTA25@UPlHRKi9rhgJOd46ztcC3D=7VNe",
		"BVmzLwqiGClxFYg7tyAndK8TrO96sHE2WXhDoSpN3v5M0kZfa@RJI1Uujbe4=PcQ",
		"BFJS81yrGKNWdvosj@4uLRbaeV7OAE5g02PQ9pTIcZCnhx3X=kql6zwHfDmiMtUY",
		"uYkcToZlK5UtVqb=3M1Ir2HE@9jSP4aRNhXdLwBOvAGFsi7yWDf80Qe6mzCJgnxp",
		"VBgD2Y57HInq8ZCabhiQuordLAT@yEjw1lvcNROf0=sX94MSmJkKF3ezWUPtpxG6",
		"9bUZwuVjOIoLyqnlk1M0re84tNH62YaCQXTAm@Big3FpKxPJscDGv=SfRW7dEzh5",
		"dtAPwJWI0zo43V2hpGy9mngaiHLN5@xCjcKFl=OM7sRrDqeYXUf61uvTZ8SBEQbk",
		"Eq68WtBuKeH1Rls7fz095SnOPThG@Vj2UmNLdo=wXJCg3vaxMpZQYbIiDrcAy4Fk",
		"QGcFt=n9zg@jCfqNKUsH5eRh8VMLASwr3bd2YOBPWk4XpoEmi7vayTD6Z01IulJx",
		"AK@aGrpmsJ4chtkw9y2Fg7zXUETxvuWHe=bnV0qMBL6RlOf5DiQCP1jSZNY3od8I",
		"rN@BoWRfXZ=d0IFOl6tmLKA538JDicqwub2EQV7y1H9zYneUThjxPSCaGvpgMks4",
		"YhrZFB2G6PWldkofxIvSRib=TJmu4V15QOptUE70j3cnz8ALgaKNXHsqDew@CMy9",
		"uOCp93=t2MhiND@QIBKzU7xHkqYLbeErZWPVFsSwolXRdA4jg8Tn5yJfcG10avm6",
		"nvXOi0uYHRojF7l1QLcNKaDg3JyT6C5Vsbq=W@rkUB4tMmd9IezZE8fwShApx2PG",
		"=4WxFMBjtzLvf8dsEqkDu97VCP3SXQYcT1eRb@NngwarG5ApyimU6IJOH0hZol2K",
		"UliqvJMg570tT2LDdxfcmNY3u@6QrjIHsAw8nZE41yphKP9kbCVB=XFGWazOeSRo",
		"exJdc8pko239Na4IhEFuVP@XDWUC=iGBqvl6YnTwHszgMjfr75ybmRA0SQt1ZLOK",
		"6MfkLqQEolRmCwiN1ntBYaGu9@zeUdK7pJyh0SZrVAb=HI3gW48XDvTPjcOxs5F2",
		"qeXajBNhAiJS62x@KUg5G3OM8wTtDFv0mcpzl9HrkdPZyVf7LnEu=YsRboIC41WQ",
		"J1xmH3Tkb6tED@B5avoLNc0pZS2FGRr=98Isw7UCP4MyQYigVhdqOjuWleXfKAzn",
		"WEAb9DhrfCilHoSBRu43nZ@TVzJtY670IMpOweKgm2=UvckXQxFs85aLyq1PNGjd"
	};
	
	private static final int MAGIC_LENGTH = indexTable.length();
	private static final int MAGIC_NUMBER = (indexTable.length() - 1);  // MUST be (power of 2 - 1)
	private static final int MAGIC_SHIFT_CNT = 6; // this SHOULD be caculated automatically
	private static final boolean REVERSE = true;
	private static final boolean RANDOM_LINE = true;
	
	private static char getChar(int lineIndex, int roundCnt, int charIndex) {
		int lineOffset = 0;
		if (RANDOM_LINE) {
			lineOffset = randLineOffset[roundCnt % randLineOffsetSize];
		} else {
			lineOffset = roundCnt;
		}
		lineIndex = (lineIndex + lineOffset) % MAGIC_LENGTH;

		return charTable[lineIndex].charAt(charIndex);
	}
	
	private static int getNum(int lineIndex, int roundCnt, char c) {
		int lineOffset = 0;
		if (RANDOM_LINE) {
			lineOffset = randLineOffset[roundCnt % randLineOffsetSize];
		} else {
			lineOffset = roundCnt;
		}
		lineIndex = (lineIndex + lineOffset) % MAGIC_LENGTH;
		return charTable[lineIndex].indexOf(c);  // here can be optimized using table-lookup
	}
	
	private static char getIndexChar(int n) {
		return indexTable.charAt(n);
	}
	
	private static int getLineIndex(char c) {
		return indexTable.indexOf(c);
	}
	

	
	private static String encode(long number) {
		List<Integer> retList = new ArrayList<>();
		
		int lineIndex = (int)number & MAGIC_NUMBER;
		
		do {
			retList.add((int)number & MAGIC_NUMBER);
			number = number >> MAGIC_SHIFT_CNT;
		} while (number > 0);
		
		String result = "";
		result += getIndexChar(lineIndex);
		
		// System.out.println("encode list:");
		int roundCnt = 0;
		for (int i : retList) {
			// System.out.print(i + " ");
			result += getChar(lineIndex, roundCnt, i);
			roundCnt += 1;
		}
		// System.out.println("");
		
		//System.out.println("result=" + result);

		return result;
	}

	
	private static long decode(String str) throws Exception {
		char indexChar = str.charAt(0);
		if (indexTable.indexOf(indexChar) < 0) {
			throw new Exception("decode failure");
		}
		int lineIndex = getLineIndex(indexChar);
		//System.out.println("decode lineIndex:" + lineIndex);
		
		long result = 0;
		int roundCnt = 0;
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (indexTable.indexOf(c) < 0) {
				throw new Exception("decode failure");
			}
			
			long num = getNum(lineIndex, roundCnt, str.charAt(i));
			//System.out.println(num + " ");
			result |= (num << (MAGIC_SHIFT_CNT * roundCnt));
			roundCnt += 1;
		}

		return result;
	}
	
	public static String idToString (int id) {
		String retStr = "";
		try {
			long number = REVERSE ? (Long.MAX_VALUE - id) : id;
			retStr = IdentifierUtils.encode(number);
		} catch (Exception e) {
			LOGGER.info("IdentifierUtils idToString failure, id={}, e={}", id, e);
		}
		
		return retStr;
	}
	
	public static String idToString(Integer id) {
		String retStr = "";
		
		if (id != null) {
			try {
				long number = REVERSE ? (Long.MAX_VALUE - id) : id;
				retStr = IdentifierUtils.encode(number);
			} catch (Exception e) {
				LOGGER.info("IdentifierUtils idToString failure, id={}, e={}", id, e);
			}
		} else {
			LOGGER.info("IdentifierUtils idToString failure, id is null");
		}
		return retStr;
	}
	
	private static byte[] calcMD5(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(src.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static String Base64MD5(String src) {
		return Base64.encodeBase64URLSafeString(calcMD5(src));
	}
	
	public static int stringToId(String s) throws Exception {
		long ret = IdentifierUtils.decode(s);
		return REVERSE ? (int)(Long.MAX_VALUE - ret) : (int)ret;
	}
	
	public static String genUid(){
		return SHORT_UUID_BUILDER.build().toString();
	}

    /**
     *
     * @param length 表示生成几位随机数
     * @return 随机数
     */
	public static String getRandomString(int length) {
		StringBuilder val = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			if( "char".equalsIgnoreCase(charOrNum) ) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val.append((char)(random.nextInt(26) + temp));
			} else {
				val.append(String.valueOf(random.nextInt(10)));
			}
		}
		return val.toString();
	}
	public static void main(String[] args) throws Exception {

		/*
		 * 测试基本case，连续小数字编码后满足如下条件:
		 * 1. 不会出现相同编码的字串
		 * 2. 相邻数字的编码不会出现明显规律性
		 */
		Set<String> ids = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			//System.out.println("==========");
			int number = 101 + i;
			if (i % 64 != 0)
			    continue;
			String idStr = IdentifierUtils.idToString(number);
			
			ids.add(idStr);
			int decodeNumber = IdentifierUtils.stringToId(idStr);
			System.out.println(number + "---" + idStr + "---" + decodeNumber);
		}
		System.out.println("set size: " + ids.size());

		System.out.println(genUid());
	}
}
