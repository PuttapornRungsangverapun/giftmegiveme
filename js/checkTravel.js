function validateForm() {
    var country = document.forms["myForm"]["country"].value;
    var startDate = document.forms["myForm"]["startDate"].value;
    var endDate = document.forms["myForm"]["endDate"].value;
    var announceDate = document.forms["myForm"]["announceDate"].value;
    var start = [];
    start = startDate.split("-");
    var end = [];
    end = endDate.split("-");
    var announce = [];
    announce = announceDate.split("/");
    var checkStart = start[0] + start[1] + start[2];
    var checkEnd = end[0] + end[1] + end[2];
    var checkAnnounce = announce[0] + announce[1] + announce[2];

    if (country == ""  || country == null) {
        alert("Press select country");
        return false;
    }
    else if (startDate == "" || endDate == "") {
        alert("Press select time");
        return false;
    }
    else if (checkStart < checkAnnounce) {
        alert("Press select a new start time");
        return false;
    }
    else if (checkEnd <= checkStart) {
        alert("Press select a new end time");
        return false;
    }

}