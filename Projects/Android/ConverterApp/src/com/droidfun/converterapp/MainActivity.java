package com.droidfun.converterapp;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;


import android.os.AsyncTask;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	private static int convert1Int=0;
	private static int convert2Int=0;
	private static Map<String,String> currencyMap = new HashMap<String,String>();
	private static boolean currFlag = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		if (android.os.Build.VERSION.SDK_INT > 9) {
//		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//		    StrictMode.setThreadPolicy(policy);
//		}   
		Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
		Spinner convert1 = (Spinner)findViewById(R.id.convert1);
		Spinner convert2 = (Spinner)findViewById(R.id.convert2);
		
		EditText convertValue1 = (EditText)findViewById(R.id.convertValue1);
		EditText convertValue2 = (EditText)findViewById(R.id.convertValue2);
		
		
		//populate first drop down
		String[] convTypes = new String[]{getString(R.string.temp), getString(R.string.length),getString(R.string.mass),getString(R.string.speed),
				getString(R.string.volume),getString(R.string.area),getString(R.string.fuel),getString(R.string.time),getString(R.string.digital)};
		ArrayAdapter arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,convTypes);
		arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		conversionType.setAdapter(arrayAdapter1);
		
		//first popup selection listener
		conversionType.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				Spinner convert1 = (Spinner)findViewById(R.id.convert1);
				Spinner convert2 = (Spinner)findViewById(R.id.convert2);
				Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
				
				EditText convertValue1 = (EditText)findViewById(R.id.convertValue1);
				EditText convertValue2 = (EditText)findViewById(R.id.convertValue2);
				
				ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(arg0.getContext(), android.R.layout.simple_spinner_item,getArray());
				arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				
				convert1.setAdapter(arrayAdapter2);
				convert2.setAdapter(arrayAdapter2);
				
				
				if(conversionType.getSelectedItem().equals(getString(R.string.temp))){
					convertValue1.setText("0");
					convertValue2.setText("32");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.length))){
					convertValue1.setText("1");
					convertValue2.setText("1000");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.mass))){
					convertValue1.setText("1");
					convertValue2.setText("1000");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.speed))){
					convertValue1.setText("1");
					convertValue2.setText("1.46667");
				}		
				else if(conversionType.getSelectedItem().equals(getString(R.string.volume))){
					convertValue1.setText("1");
					convertValue2.setText("4");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.area))){
					convertValue1.setText("1");
					convertValue2.setText("100");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.fuel))){
					convertValue1.setText("1");
					convertValue2.setText("1.20095");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.time))){
					convertValue1.setText("1");
					convertValue2.setText("0.001");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.digital))){
					convertValue1.setText("1");
					convertValue2.setText("0.125");
				}
				
				convert1Int = convert1.getSelectedItemPosition();
				convert2Int = convert2.getSelectedItemPosition();
				
				if(convert1Int == convert2Int){
					convert2.setSelection(convert1Int+1);
				}
				arrayAdapter2.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		convert1.setOnItemSelectedListener(new OnItemSelectedListener(){
			
			Spinner convert1 = (Spinner)findViewById(R.id.convert1);
			Spinner convert2 = (Spinner)findViewById(R.id.convert2);
			Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				EditText convertValue1 = (EditText)findViewById(R.id.convertValue1);
				EditText convertValue2 = (EditText)findViewById(R.id.convertValue2);
				
				if(conversionType.getSelectedItem().equals(getString(R.string.temp))){
					convertValue2.setText("32");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.length))){
					convertValue1.setText("1");
					convertValue2.setText("1000");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.mass))){
					convertValue1.setText("1");
					convertValue2.setText("1000");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.speed))){
					convertValue1.setText("1");
					convertValue2.setText("1.46667");
				}		
				else if(conversionType.getSelectedItem().equals(getString(R.string.volume))){
					convertValue1.setText("1");
					convertValue2.setText("4");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.area))){
					convertValue1.setText("1");
					convertValue2.setText("100");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.fuel))){
					convertValue1.setText("1");
					convertValue2.setText("1.20095");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.time))){
					convertValue1.setText("1");
					convertValue2.setText("0.001");
				}
				else if(conversionType.getSelectedItem().equals(getString(R.string.digital))){
					convertValue1.setText("1");
					convertValue2.setText("0.125");
				}

				if(convert1.getSelectedItem().equals(convert2.getSelectedItem())){
						if(convert1Int != convert2.getSelectedItemPosition())	
							convert2.setSelection(convert1Int);
							else
								convert2.setSelection(convert1Int+1);
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		convert2.setOnItemSelectedListener(new OnItemSelectedListener(){
					
					Spinner convert1 = (Spinner)findViewById(R.id.convert1);
					Spinner convert2 = (Spinner)findViewById(R.id.convert2);
					
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						if(convert2.getSelectedItem().equals(convert1.getSelectedItem())){
							if(convert2Int != convert1.getSelectedItemPosition())	
							convert1.setSelection(convert2Int);
							else
								convert1.setSelection(convert2Int+1);
						}

					}
		
					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		convertValue1.addTextChangedListener(new TextWatcher() {
			Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
			
			EditText convertValue1 = (EditText)findViewById(R.id.convertValue1);
			EditText convertValue2 = (EditText)findViewById(R.id.convertValue2);

			Spinner convert1 = (Spinner)findViewById(R.id.convert1);
			Spinner convert2 = (Spinner)findViewById(R.id.convert2);
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String str = convertValue1.getText().toString();
				if(!str.equals("")){
					float f = Float.valueOf(Float.parseFloat(str));
					if(conversionType.getSelectedItem().equals(getString(R.string.temp))){
						
						if(convert1.getSelectedItem().equals(getString(R.string.celcius))){
							if(convert2.getSelectedItem().equals(getString(R.string.farenheit))){
								convertValue2.setText(convertToFaren(f));
							}
							else{
								convertValue2.setText(convertCToKelvin(f));
							}
							
						}
						else if(convert1.getSelectedItem().equals(getString(R.string.farenheit))){
							if(convert2.getSelectedItem().equals(getString(R.string.celcius))){
								convertValue2.setText(convertToCelsius(f));
							}
							else{
								convertValue2.setText(convertFToKelvin(f));
							}
						}
						
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.length))){
						convertValue2.setText("1000");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.mass))){
						convertValue2.setText("1000");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.speed))){
						convertValue2.setText("1.46667");
					}		
					else if(conversionType.getSelectedItem().equals(getString(R.string.volume))){
						convertValue2.setText("4");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.area))){
						convertValue2.setText("100");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.fuel))){
						convertValue2.setText("1.20095");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.time))){
						convertValue2.setText("0.001");
					}
					else if(conversionType.getSelectedItem().equals(getString(R.string.digital))){
						convertValue2.setText("0.125");
					}
				}
				else{
					convertValue1.setText("0");
				}
				
				
			}
		});
		
		convertValue2.addTextChangedListener(new TextWatcher() {
			Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
			
			EditText convertValue1 = (EditText)findViewById(R.id.convertValue1);
			EditText convertValue2 = (EditText)findViewById(R.id.convertValue2);

			Spinner convert1 = (Spinner)findViewById(R.id.convert1);
			Spinner convert2 = (Spinner)findViewById(R.id.convert2);
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String str = convertValue2.getText().toString();
				if(!str.equals("")){
					
					
				}
				else{
					convertValue2.setText("0");
				}
			}
		});
	
		Spinner cur1 = (Spinner)findViewById(R.id.cur1);
		Spinner cur2 = (Spinner)findViewById(R.id.cur2);
		
		
		
		currencyMap.put("USD", "U.S. Dollar");
		currencyMap.put("INR", "Indian Rupee");
		currencyMap.put("EUR", "Euro");
		currencyMap.put("GBP", "British Pound");
		currencyMap.put("JPY", "Japanese Yen");
		currencyMap.put("AUD", "Australian Dollar");
		currencyMap.put("SGD", "Singapore Dollar");
		
		currencyMap.put("AFA", "Afghanistan Afghani");
    	currencyMap.put("ALL", "Albanian Lek");
    	currencyMap.put("DZD", "Algerian Dinar");
    	currencyMap.put("ARS", "Argentine Peso");
    	currencyMap.put("AWG", "Aruba Florin");
    	
    	currencyMap.put("BSD", "Bahamian Dollar");
    	currencyMap.put("BHD", "Bahraini Dinar");
    	currencyMap.put("BDT", "Bangladesh Taka");
    	currencyMap.put("BBD", "Barbados Dollar");
    	currencyMap.put("BZD", "Belize Dollar");
    	currencyMap.put("BMD", "Bermuda Dollar");
    	currencyMap.put("BTN", "Bhutan Ngultrum");
    	currencyMap.put("BOB", "Bolivian Boliviano");
    	currencyMap.put("BWP", "Botswana Pula");
    	currencyMap.put("BRL", "Brazilian Real");
    	
    	currencyMap.put("BND", "Brunei Dollar");
    	currencyMap.put("BIF", "Burundi Franc");
    	currencyMap.put("XOF", "CFA Franc (BCEAO)");
    	currencyMap.put("XAF", "CFA Franc (BEAC)");
    	currencyMap.put("KHR", "Cambodia Riel");
    	currencyMap.put("CAD", "Canadian Dollar");
    	currencyMap.put("CVE", "Cape Verde Escudo");
    	currencyMap.put("KYD", "Cayman Islands Dollar");
    	currencyMap.put("CLP", "Chilean Peso");
    	currencyMap.put("CNY", "Chinese Yuan");
    	currencyMap.put("COP", "Colombian Peso");
    	currencyMap.put("KMF", "Comoros Franc");
    	currencyMap.put("CRC", "Costa Rica Colon");
    	currencyMap.put("HRK", "Croatian Kuna");
    	currencyMap.put("CUP", "Cuban Peso");
    	currencyMap.put("CYP", "Cyprus Pound");
    	currencyMap.put("CZK", "Czech Koruna");
    	currencyMap.put("DKK", "Danish Krone");
    	currencyMap.put("DJF", "Dijibouti Franc");
    	currencyMap.put("DOP", "Dominican Peso");
    	currencyMap.put("XCD", "East Caribbean Dollar");
    	currencyMap.put("EGP", "Egyptian Pound");
    	currencyMap.put("SVC", "El Salvador Colon");
    	currencyMap.put("EEK", "Estonian Kroon");
    	currencyMap.put("ETB", "Ethiopian Birr");
    	
    	currencyMap.put("FKP", "Falkland Islands Pound");
    	currencyMap.put("GMD", "Gambian Dalasi");
    	currencyMap.put("GHC", "Ghanian Cedi");
    	currencyMap.put("GIP", "Gibraltar Pound");
    	currencyMap.put("XAU", "Gold Ounces");
    	currencyMap.put("GTQ", "Guatemala Quetzal");
    	currencyMap.put("GNF", "Guinea Franc");
    	currencyMap.put("GYD", "Guyana Dollar");
    	currencyMap.put("HTG", "Haiti Gourde");
    	currencyMap.put("HNL", "Honduras Lempira");
    	currencyMap.put("HKD", "Hong Kong Dollar");
    	currencyMap.put("HUF", "Hungarian Forint");
    	currencyMap.put("ISK", "Iceland Krona");
    	
    	currencyMap.put("IDR", "Indonesian Rupiah");
    	currencyMap.put("IQD", "Iraqi Dinar");
    	currencyMap.put("ILS", "Israeli Shekel");
    	currencyMap.put("JMD", "Jamaican Dollar");
    	
    	currencyMap.put("JOD", "Jordanian Dinar");
    	currencyMap.put("KZT", "Kazakhstan Tenge");
    	currencyMap.put("KES", "Kenyan Shilling");
    	currencyMap.put("KRW", "Korean Won");
    	currencyMap.put("KWD", "Kuwaiti Dinar");
    	currencyMap.put("LAK", "Lao Kip");
    	currencyMap.put("LVL", "Latvian Lat");
    	currencyMap.put("LBP", "Lebanese Pound");
    	currencyMap.put("LSL", "Lesotho Loti");
    	currencyMap.put("LRD", "Liberian Dollar");
    	currencyMap.put("LYD", "Libyan Dinar");
    	currencyMap.put("LTL", "Lithuanian Lita");
    	currencyMap.put("MOP", "Macau Pataca");
    	currencyMap.put("MKD", "Macedonian Denar");
    	currencyMap.put("MGF", "Malagasy Franc");
    	currencyMap.put("MWK", "Malawi Kwacha");
    	currencyMap.put("MYR", "Malaysian Ringgit");
    	currencyMap.put("MVR", "Maldives Rufiyaa");
    	currencyMap.put("MTL", "Maltese Lira");
    	currencyMap.put("MRO", "Mauritania Ougulya");
    	currencyMap.put("MUR", "Mauritius Rupee");
    	currencyMap.put("MXN", "Mexican Peso");
    	currencyMap.put("MDL", "Moldovan Leu");
    	currencyMap.put("MNT", "Mongolian Tugrik");
    	currencyMap.put("MAD", "Moroccan Dirham");
    	currencyMap.put("MZM", "Mozambique Metical");
    	currencyMap.put("MMK", "Myanmar Kyat");
    	currencyMap.put("NAD", "Namibian Dollar");
    	currencyMap.put("NPR", "Nepalese Rupee");
    	currencyMap.put("ANG", "Neth Antilles Guilder");
    	currencyMap.put("NZD", "New Zealand Dollar");
    	currencyMap.put("NIO", "Nicaragua Cordoba");
    	currencyMap.put("NGN", "Nigerian Naira");
    	currencyMap.put("KPW", "North Korean Won");
    	currencyMap.put("NOK", "Norwegian Krone");
    	currencyMap.put("OMR", "Omani Rial");
    	currencyMap.put("XPF", "Pacific Franc");
    	currencyMap.put("PKR", "Pakistani Rupee");
    	currencyMap.put("XPD", "Palladium Ounces");
    	currencyMap.put("PAB", "Panama Balboa");
    	currencyMap.put("PGK", "Papua New Guinea Kina");
    	currencyMap.put("PYG", "Paraguayan Guarani");
    	currencyMap.put("PEN", "Peruvian Nuevo Sol");
    	currencyMap.put("PHP", "Philippine Peso");
    	currencyMap.put("XPT", "Platinum Ounces");
    	currencyMap.put("PLN", "Polish Zloty");
    	currencyMap.put("QAR", "Qatar Rial");
    	currencyMap.put("ROL", "Romanian Leu");
    	currencyMap.put("RUB", "Russian Rouble");
    	currencyMap.put("WST", "Samoa Tala");
    	currencyMap.put("STD", "Sao Tome Dobra");
    	currencyMap.put("SAR", "Saudi Arabian Riyal");
    	currencyMap.put("SCR", "Seychelles Rupee");
    	currencyMap.put("SLL", "Sierra Leone Leone");
    	currencyMap.put("XAG", "Silver Ounces");
    	
    	currencyMap.put("SKK", "Slovak Koruna");
    	currencyMap.put("SIT", "Slovenian Tolar");
    	currencyMap.put("SBD", "Solomon Islands Dollar");
    	currencyMap.put("SOS", "Somali Shilling");
    	currencyMap.put("ZAR", "South African Rand");
    	currencyMap.put("LKR", "Sri Lanka Rupee");
    	currencyMap.put("SHP", "St Helena Pound");
    	currencyMap.put("SDD", "Sudanese Dinar");
    	currencyMap.put("SRG", "Surinam Guilder");
    	currencyMap.put("SZL", "Swaziland Lilageni");
    	currencyMap.put("SEK", "Swedish Krona");
    	currencyMap.put("TRY", "Turkey Lira");
    	currencyMap.put("CHF", "Swiss Franc");
    	currencyMap.put("SYP", "Syrian Pound");
    	currencyMap.put("TWD", "Taiwan Dollar");
    	currencyMap.put("TZS", "Tanzanian Shilling");
    	currencyMap.put("THB", "Thai Baht");
    	currencyMap.put("TOP", "Tonga Pa'anga");
    	currencyMap.put("TTD", "Trinidad&amp;Tobago Dollar");
    	currencyMap.put("TND", "Tunisian Dinar");
    	currencyMap.put("TRL", "Turkish Lira");
    	
    	currencyMap.put("AED", "UAE Dirham");
    	currencyMap.put("UGX", "Ugandan Shilling");
    	currencyMap.put("UAH", "Ukraine Hryvnia");
    	currencyMap.put("UYU", "Uruguayan New Peso");
    	currencyMap.put("VUV", "Vanuatu Vatu");
    	currencyMap.put("VEB", "Venezuelan Bolivar");
    	currencyMap.put("VND", "Vietnam Dong");
    	currencyMap.put("YER", "Yemen Riyal");
    	currencyMap.put("YUM", "Yugoslav Dinar");
    	currencyMap.put("ZMK", "Zambian Kwacha");
    	currencyMap.put("ZWD", "Zimbabwe Dollar");
    
//		String[] currTypes = new String[currencyMap.size()];
//		Iterator<String> it = currencyMap.values().iterator();
//		int i=0;
//		while(it.hasNext()){
//			currTypes[i] = it.next();
//			i++;
//		}
    	String[] currTypes = {
				getString(R.string.USD),getString(R.string.INR),getString(R.string.AUD),getString(R.string.GBP),getString(R.string.EUR),getString(R.string.JPY),getString(R.string.SGD),getString(R.string.AFA),getString(R.string.ALL),
				getString(R.string.DZD),getString(R.string.ARS),getString(R.string.AWG),getString(R.string.BSD),getString(R.string.BHD),getString(R.string.BDT),getString(R.string.BBD),getString(R.string.BZD),
				getString(R.string.BMD),getString(R.string.BTN),getString(R.string.BOB),getString(R.string.BWP),getString(R.string.BRL),getString(R.string.BND),getString(R.string.BIF),getString(R.string.XOF),
				getString(R.string.XAF),getString(R.string.KHR),getString(R.string.CAD),getString(R.string.CVE),getString(R.string.KYD),getString(R.string.CLP),getString(R.string.CNY),getString(R.string.COP),
				getString(R.string.KMF),getString(R.string.CRC),getString(R.string.HRK),getString(R.string.CUP),getString(R.string.CYP),getString(R.string.CZK),getString(R.string.DKK),getString(R.string.DJF),
				getString(R.string.DOP),getString(R.string.XCD),getString(R.string.EGP),getString(R.string.SVC),getString(R.string.EEK),getString(R.string.ETB),getString(R.string.FKP),getString(R.string.GMD),
				getString(R.string.GHC),getString(R.string.GIP),getString(R.string.XAU),getString(R.string.GTQ),getString(R.string.GNF),getString(R.string.GYD),getString(R.string.HTG),getString(R.string.HNL),
				getString(R.string.HKD),getString(R.string.HUF),getString(R.string.ISK),getString(R.string.IDR),getString(R.string.IQD),getString(R.string.ILS),getString(R.string.JMD),getString(R.string.JOD),
				getString(R.string.KZT),getString(R.string.KES),getString(R.string.KRW),getString(R.string.KWD),getString(R.string.LAK),getString(R.string.LVL),getString(R.string.LBP),getString(R.string.LSL),
				getString(R.string.LRD),getString(R.string.LYD),getString(R.string.LTL),getString(R.string.MOP),getString(R.string.MKD),getString(R.string.MGF),getString(R.string.MWK),getString(R.string.MYR),
				getString(R.string.MVR),getString(R.string.MTL),getString(R.string.MRO),getString(R.string.MUR),getString(R.string.MXN),getString(R.string.MDL),getString(R.string.MNT),getString(R.string.MAD),
				getString(R.string.MZM),getString(R.string.MMK),getString(R.string.NAD),getString(R.string.NPR),getString(R.string.ANG),getString(R.string.NZD),getString(R.string.NIO),getString(R.string.NGN),
				getString(R.string.KPW),getString(R.string.NOK),getString(R.string.OMR),getString(R.string.XPF),getString(R.string.PKR),getString(R.string.XPD),getString(R.string.PAB),getString(R.string.PGK),
				getString(R.string.PYG),getString(R.string.PEN),getString(R.string.PHP),getString(R.string.XPT),getString(R.string.PLN),getString(R.string.QAR),getString(R.string.ROL),getString(R.string.RUB),
				getString(R.string.WST),getString(R.string.STD),getString(R.string.SAR),getString(R.string.SCR),getString(R.string.SLL),getString(R.string.XAG),getString(R.string.SKK),getString(R.string.SIT),
				getString(R.string.SBD),getString(R.string.SOS),getString(R.string.ZAR),getString(R.string.LKR),getString(R.string.SHP),getString(R.string.SDD),getString(R.string.SRG),getString(R.string.SZL),
				getString(R.string.SEK),getString(R.string.TRY),getString(R.string.CHF),getString(R.string.SYP),getString(R.string.TWD),getString(R.string.TZS),getString(R.string.THB),getString(R.string.TOP),
				getString(R.string.TTD),getString(R.string.TND),getString(R.string.TRL),getString(R.string.AED),getString(R.string.UGX),getString(R.string.UAH),getString(R.string.UYU),getString(R.string.VUV),
				getString(R.string.VEB),getString(R.string.VND),getString(R.string.YER),getString(R.string.YUM),getString(R.string.ZMK),getString(R.string.ZWD)};
		ArrayAdapter arrayCurrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,currTypes);
		arrayCurrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cur1.setAdapter(arrayCurrAdapter);
		cur2.setAdapter(arrayCurrAdapter);
		
		EditText cur1Value = (EditText)findViewById(R.id.cur1Value);
		EditText cur2Value = (EditText)findViewById(R.id.cur2Value);
		
		
		
		cur1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				EditText cur1Value = (EditText)findViewById(R.id.cur1Value);
				EditText cur2Value = (EditText)findViewById(R.id.cur2Value);
				
				Spinner cur1 = (Spinner)findViewById(R.id.cur1);
				Spinner cur2 = (Spinner)findViewById(R.id.cur2);
				
					cur2Value.setText(getJSON(cur1.getSelectedItem().toString(),cur2.getSelectedItem().toString()));
				
				TextView textView3 = (TextView)findViewById(R.id.textView3);
				textView3.setText(cur1Value.getText()+" "+cur1.getSelectedItem().toString()+" equals");
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cur2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				EditText cur1Value = (EditText)findViewById(R.id.cur1Value);
				EditText cur2Value = (EditText)findViewById(R.id.cur2Value);
				
				Spinner cur1 = (Spinner)findViewById(R.id.cur1);
				Spinner cur2 = (Spinner)findViewById(R.id.cur2);
				
				cur1Value.setText(getJSON(cur2.getSelectedItem().toString(),cur1.getSelectedItem().toString()));
				
				
				TextView textView4 = (TextView)findViewById(R.id.textView4);
				textView4.setText(cur2Value.getText()+" "+cur2.getSelectedItem().toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		cur1.setSelection(0);
		cur2.setSelection(1);
		
		cur1Value.setText("1");
		cur2Value.setText(getJSON(cur1.getSelectedItem().toString(),cur2.getSelectedItem().toString()));
	}
	
	
	private String[] getArray(){
		String[] list = null;
		Spinner conversionType = (Spinner)findViewById(R.id.conversionType);
		if(conversionType.getSelectedItem().equals(getString(R.string.temp))){
			list = new String[]{getString(R.string.celcius), getString(R.string.farenheit),getString(R.string.kelvin)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.length))){
			list = new String[]{getString(R.string.km), getString(R.string.meter),getString(R.string.cm),
					getString(R.string.mm), getString(R.string.mcg),getString(R.string.longton),getString(R.string.shortton), 
					getString(R.string.stone),getString(R.string.stone),getString(R.string.pound),getString(R.string.ounce)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.mass))){
			list = new String[]{getString(R.string.mt), getString(R.string.kg),getString(R.string.g),
					getString(R.string.mg), getString(R.string.mile),getString(R.string.yard),getString(R.string.foot), 
					getString(R.string.inch),getString(R.string.nauti)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.speed))){
			list = new String[]{getString(R.string.mph), getString(R.string.fps),getString(R.string.mts), 
					getString(R.string.kmh),getString(R.string.knot)};
		}		
		else if(conversionType.getSelectedItem().equals(getString(R.string.volume))){
			list = new String[]{getString(R.string.usgal), getString(R.string.usquart),getString(R.string.uspint)
					,getString(R.string.uscup), getString(R.string.usoz),getString(R.string.ustbsp)
					,getString(R.string.ustsp), getString(R.string.cubic),getString(R.string.litr)
					,getString(R.string.militer), getString(R.string.impgal),getString(R.string.impq)
					,getString(R.string.imppint), getString(R.string.impoz),getString(R.string.imptbsp)
					,getString(R.string.imptsp), getString(R.string.cubfoot),getString(R.string.cubinch)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.area))){
			list = new String[]{getString(R.string.sqkm), getString(R.string.hect),getString(R.string.sqm)
					,getString(R.string.sqmile), getString(R.string.acre),getString(R.string.sqy)
					,getString(R.string.sqf), getString(R.string.sqi)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.fuel))){
			list = new String[]{getString(R.string.mpgu), getString(R.string.mpgi),getString(R.string.kml),getString(R.string.l100)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.time))){
			list = new String[]{getString(R.string.nano), getString(R.string.micro),getString(R.string.milli)
					,getString(R.string.sec), getString(R.string.min),getString(R.string.hour)
					,getString(R.string.day), getString(R.string.week),getString(R.string.month)
					,getString(R.string.year), getString(R.string.decade),getString(R.string.century)};
		}
		else if(conversionType.getSelectedItem().equals(getString(R.string.digital))){
			list = new String[]{getString(R.string.bit), getString(R.string.bytes),getString(R.string.kilobit)
					,getString(R.string.kilobyte), getString(R.string.megabit),getString(R.string.megabyte)
					,getString(R.string.gigabit), getString(R.string.gigabyte),getString(R.string.terabit)
					,getString(R.string.terabyte), getString(R.string.petabit),getString(R.string.petabyte)};
		}
		return list;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private String convertToCelsius(float faren){
    	return String.valueOf((faren - 32) * 5 / 9);
    }
    
    private String convertToFaren(float celsius){
    	return String.valueOf(((celsius * 9)/5) + 32);
    }
    
    private String convertCToKelvin(float celsius){
    	return String.valueOf(celsius+273.15);
    }
    
    private String convertFToKelvin(float faren){
    	return String.valueOf(convertToCelsius(faren)+273.15);
    }
    
    private String getJSON(String cur1, String cur2){
    	AsyncTask<String, Void, String> str = new WebService().execute(cur1,cur2);
    	String value = null;
    	try {
			value =  str.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
        }
    
    private class WebService extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
        	String str="http://currencies.apps.grandtrunk.net/getlatest/"+ getCurr(params[0]) +"/"+ getCurr(params[1]);
        	//String str="http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate?FromCurrency="+ getCurr(cur1) +"&ToCurrency="+getCurr(cur2);
        	URL url;
            String line = null;
			try {
				url = new URL(str);
			
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream response = conn.getInputStream();

                URLConnection urlc=url.openConnection();
                BufferedReader bfr=new BufferedReader(new InputStreamReader(urlc.getInputStream()));

                line=bfr.readLine();
            }
    	        catch(Exception e){
    	        	e.printStackTrace();
    	        }
            
            return line;
        }

        @Override
        protected void onPostExecute(String result) {
            
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
    
    private static String getCurr(String currDescription) {
    	Iterator<Entry<String, String>> iterator= currencyMap.entrySet().iterator();
    	String currShort = null;
    	
        while(iterator.hasNext())
        {
            Entry entry =(Entry)iterator.next();  
            if(entry.getValue().equals(currDescription)){
            	currShort = entry.getKey().toString();
            }
        }
		return currShort;
    }
    
}
