package br.edu.ifpr.consultacondutor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

import br.edu.ifpr.consultacondutor.model.Placa;
import br.edu.ifpr.consultacondutor.model.Veiculo;

public class PlacaAPIService {

	public String getResponse(Placa placa) throws SAXException, IOException, ParserConfigurationException {
		String xmlResponse = "Veículo não encontrado.";

		String username = "git-tester";
		String url = "http://www.placaapi.com/api/reg.asmx/CheckBrazil?" 
				+ "RegistrationNumber=" + placa.getPlaca() + "&username="
				+ username;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.toString())));

		NodeList errNodes = doc.getElementsByTagName("Vehicle");
		if (errNodes.getLength() > 0) {
			Element err = (Element) errNodes.item(0);
			xmlResponse = err.getElementsByTagName("vehicleJson").item(0).getTextContent();
		}
		return xmlResponse;
	}
	
	public Veiculo fromJson(String xmlResponse) {
		Gson gson = new Gson();
		Veiculo veiculo = gson.fromJson(xmlResponse, Veiculo.class);
		
		return veiculo;
	}
}
