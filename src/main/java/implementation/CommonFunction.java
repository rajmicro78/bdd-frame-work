package implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.qa.util.ConfigReader;

public class CommonFunction {
	private String email;
	Properties prop;
	private ConfigReader configreader;
	static String postalcode;
	static String personname;
	static String familyname;
	static String billingcity;
	static String streetAddress;
	static String phoneNumber;
	static String securitynumber;

	public String getemail() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
		email = prop.getProperty("emailstart");
		email = email + "autoregression-" + getDateDDMMM() + "@brandsdalgroup.com";
		return email;
	}

	public String envioranment() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
		String envio = prop.getProperty("envioranment");
		envio = envio + ".brandsdalgroup.com";
		return envio;
	}

	public String website(String sitename) {
		String sitecode = null;
		switch (sitename) {

		case "Blivakker.no":
			sitecode = "7002";
			break;
		case "Cocopanda.de":
			sitecode = "7010";
			break;
		case "Cocopanda.dk":
			sitecode = "7004";
			break;
		case "Cocopanda.se":
			sitecode = "7007";
			break;
		case "Cocopanda.fi":
			sitecode = "7008";
			break;
		case "Cocopanda.pl":
			sitecode = "7012";
			break;
		case "Netthandelen.no":
			sitecode = "7014";
			break;
		case "Cocopanda.nl":
			sitecode = "7015";
			break;
		}

		return sitecode;
	}

	public String getDateDDMMM() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public int getRandom(int max) {
		return (int) (Math.random() * max);
	}

	public String getGC(String sitename) {
		String GCname = null;
		if (sitename.equalsIgnoreCase("BliVakker.no") || sitename.equalsIgnoreCase("Cocopanda.dk")) {
			GCname = "Gavekort";
		} else if (sitename.equalsIgnoreCase("Cocopanda.se")) {
			GCname = "Presentkort";
		} else if (sitename.equalsIgnoreCase("Cocopanda.nl")) {
			GCname = "CADEAUBON";
		} else if (sitename.equalsIgnoreCase("Cocopanda.fi")) {
			GCname = "Lahjakortit";
		} else if (sitename.equalsIgnoreCase("Cocopanda.de")) {
			GCname = "Geschenkgutscheine";
		} else if (sitename.equalsIgnoreCase("Cocopanda.de")) {
			GCname = "Bony podarunkowe";
		} else if (sitename.equalsIgnoreCase("netthandelen.no")) {
			GCname = "spa";
		}

		return GCname;

	}
	/*
	 * public void klarnadetail(String sitecode) { if
	 * (sitecode.equalsIgnoreCase("BliVakker.no") ||
	 * sitecode.equalsIgnoreCase("Netthandelen.no")) { postalcode = "0563";
	 * personname = "Testperson-no"; familyname = "Approved"; streetAddress =
	 * "Sæffleberggate 56"; phoneNumber = "40123456"; securitynumber =
	 * "01087000571"; billingcity = "Oslo"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.nl")) { postalcode = "2521VA";
	 * personname = "Testperson-nl"; familyname = "Approved"; streetAddress =
	 * "Neherkade 1"; phoneNumber = "0612345678"; securitynumber = "10071970";
	 * billingcity = "Gravenhage"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.at")) { postalcode = "8071"; personname
	 * = "Testperson-at"; familyname = "Approved"; streetAddress =
	 * "Klarna-Straße 1/2/3"; phoneNumber = "06762600000"; securitynumber =
	 * "14041960"; billingcity = "Hausmannstätten"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.dk")) { postalcode = "6800"; personname
	 * = "Testperson-dk"; familyname = "Approved"; streetAddress =
	 * "Sæffleberggate 56,1 mf"; phoneNumber = "20123456"; securitynumber =
	 * "0801363945"; billingcity = "Varde"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.fi")) { postalcode = "28100";
	 * personname = "Testperson-fi"; familyname = "Approved"; streetAddress =
	 * "Kiväärikatu 10"; phoneNumber = "0401234567"; securitynumber = "190122-829F";
	 * billingcity = "Pori"; } else if (sitecode.equalsIgnoreCase("Cocopanda.de")) {
	 * postalcode = "41460"; personname = "Testperson-de"; familyname = "Approved";
	 * streetAddress = "Hellersbergstraße 14"; phoneNumber = "522113356";
	 * securitynumber = "07071960"; billingcity = "Neuss"; } else if
	 * (sitecode.equalsIgnoreCase("Cocopanda.se")) { postalcode = "27393";
	 * personname = "Approved16"; familyname = "Sweden16"; streetAddress =
	 * "Ryggevägen 3"; phoneNumber = "0701234567"; securitynumber = "410321-9202";
	 * billingcity = "TOMELILLA"; } }
	 */
}
