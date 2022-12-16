package main.data;

import java.util.Arrays;

public class OrderInfo {
	public int showId;
	public String name;
	public String phone;
	public int[] chairsIds;
	public int memberId;

	@Override
	public String toString() {
		return "OrderInfo [showId=" + showId + ", name=" + name + ", phone=" + phone + ", chairsIds="
				+ Arrays.toString(chairsIds) + ", memberId=" + memberId + "]";
	}
	@Override
	public boolean equals(Object object){
		if(object.equals(this))
			return true;
		else if(object instanceof OrderInfo info){
			return showId==info.showId & Arrays.equals(chairsIds, info.chairsIds) && memberId==info.memberId;
		}
		return false;
	}

}
