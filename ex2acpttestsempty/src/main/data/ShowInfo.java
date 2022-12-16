package main.data;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class ShowInfo {
	public String city;
	public String hall;
	public String name;
	public String description;
	public boolean hastime;
	public LocalTime showTime;
	public long showDate;
	public long lastOrderDate;
	public double ticketCost;
	public List<OrderInfo> userstoinform = new LinkedList<>();

	public ShowInfo() {
		showTime = null;
	}

	@Override
	public String toString() {
		return "ShowInfo [city=" + city + ", hall=" + hall + ", name=" + name + ", description=" + description
				+ ", hastime=" + hastime + ", showTime=" + showTime + ", showDate=" + convertTime(showDate)
				+ ", lastOrderDate=" + convertTime(lastOrderDate) + ", ticketCost=" + ticketCost + ", userstoinform="
				+ userstoinform + "]";
	}

	public String convertTime(long time) {
		Date date = new Date(time);
		Format format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date);
	}
	@Override
	public boolean equals(Object object){ //compares space occupied in specific halls (meaning true is 2 shows at same place at same time
		if(object.equals(this))
			return true;
		else if(object instanceof ShowInfo info){
			return city.equals(info.city) & hall.equals(info.hall) & showDate==info.showDate & showTime.equals(info.showTime);
		}
		return false;
	}
}