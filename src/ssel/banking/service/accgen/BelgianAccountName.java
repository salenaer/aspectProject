package ssel.banking.service.accgen;

public class BelgianAccountName {
	
	private static final long ACC_CHECK = 97;
	private static final int TOTAL_LENGTH = 14;
	private static final int PREFIX_LENGTH = 3;
	private static final int SUFFIX_LENGTH = 2;
	private static final int MAIN_LENGTH = 7;
	private static final String SEP_CHAR = "-";
	
	private long prefix;
	private long main;
	private long suffix;
	private String str;
	
	public BelgianAccountName(long prefix, long main) {
		if(prefix<0||main<0)
			throw new IllegalArgumentException("invalid belgian account (account numbers may not be negative): "+prefix+"-"+main);
		
		this.prefix=prefix;
		this.main=main;
		this.suffix=calcSuffix();
		this.str=makeString();
	}
	
	private long calcSuffix() {
		long res = getPrefix();
		for(int i=0;i<MAIN_LENGTH;++i)
			res*=10;
		
		res+=getMain();
		return res%ACC_CHECK;
	}

	public long getPrefix() {
		return prefix;
	}
	
	public long getSuffix() {
		return suffix;
	}
	
	public long getMain() {
		return main;
	}
	
	protected String makeString() {
		
		String prefixStr = makeString(prefix,PREFIX_LENGTH);
		String mainStr = makeString(main,MAIN_LENGTH);
		String suffixStr = makeString(suffix,SUFFIX_LENGTH);
		
		return prefixStr+SEP_CHAR+mainStr+SEP_CHAR+suffixStr;
	}
	
	private String makeString(Long prefix2, int length) {
		String prefixStr = prefix2.toString();
		if(prefixStr.length()>length)
			throw new IllegalArgumentException("invalid belgian account (invalid subpart length): "+prefix2);
		for(int i  =prefixStr.length();i<length;++i)
			prefixStr="0"+prefixStr;
		return prefixStr;
	}

	public String toString() {
		
		return str;
	}
	
	public static BelgianAccountName buildFromString(String accname) {
		
		if(accname.length()!=TOTAL_LENGTH)
			throw new IllegalArgumentException("invalid belgian account (bad length): "+accname);
		
		BelgianAccountName res= new BelgianAccountName(
			new Integer(accname.substring(0,PREFIX_LENGTH)).intValue(),
			new Long(accname.substring(PREFIX_LENGTH+1, PREFIX_LENGTH+1+MAIN_LENGTH)).longValue());
		
		if(res.getSuffix()!=new Integer(accname.substring(PREFIX_LENGTH+1+MAIN_LENGTH+1, TOTAL_LENGTH)).intValue())
			throw new IllegalArgumentException("invalid belgian account (bad crc): "+accname);
		
		return res;
	}
}
