package com.hotel.automation.component;

import java.util.List;

import com.hotel.automation.target.Pluggable;

/**
 * Sensor interface for detection
 * @author vtkrishn
 *
 */
public interface Sensor {
	public void start();
	public String getName();
	public int getFloorNo();
	public void registerComponent(Pluggable component);
	public void unRegisterComponent(Pluggable component);
	public List<Pluggable> getComponents();
	public void stop();
}
