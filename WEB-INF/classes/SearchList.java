import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class SearchList {
	private String idCard;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String phoneNumber;
	private String email;
	private String picturePath;
	private String lineId;

	private int travelId;
	private String country;
	private String detail;
	private String hashTag;
	private String startDate;
	private String endDate;
	private String status;
	private String currentDate;


	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicturePath() {
		return "picture\\"+picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public String getStartDate() {

		return startDate;
	}

	public void setStartDate(String startDate) throws  ParseException {
		String[] myDate = startDate.split("\\s");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format2 = new SimpleDateFormat("dd MMM yyyy");
    Date date = format1.parse(myDate[0]);
		this.startDate = format2.format(date);
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) throws  ParseException {
		String[] myDate = endDate.split("\\s");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format2 = new SimpleDateFormat("dd MMM yyyy");
    Date date = format1.parse(myDate[0]);
		this.endDate = format2.format(date);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}




}
