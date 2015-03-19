package net.emcheris.spboot.web.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private static final Logger LOG = LoggerFactory.getLogger(DateFormatter.class);
	
	private SimpleDateFormat sdfEN;
	private SimpleDateFormat sdfFR;
	
	public DateFormatter() {
		sdfEN = new SimpleDateFormat("yyyy/MM/dd");
		sdfEN.setLenient(false);

		sdfFR = new SimpleDateFormat("dd/MM/yyyy");
		sdfFR.setLenient(false);
	}
	
	@Override
	public String print(Date date, Locale locale) {
		if (date == null) {
			return null;
		}
		
		return sdfFR.format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if (text == null || text.trim().equals("")) {
			return null;
		}
		
		Date date = null;
		try {
			date = sdfFR.parse(text.trim());
		} catch (ParseException e) {
			LOG.error("Unable to parse the date : " + text);
		}
		
		return date;
	}

}
