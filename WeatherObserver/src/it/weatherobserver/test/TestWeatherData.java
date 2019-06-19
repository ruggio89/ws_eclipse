package it.weatherobserver.test;

import it.weatherobserver.observer.CurrentConditionsDisplay;
import it.weatherobserver.observer.StatisticsDisplay;
import it.weatherobserver.subject.WeatherData;

public class TestWeatherData {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		//ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
		
		statisticsDisplay.update(80, 65, 65.7f);
	}

}
