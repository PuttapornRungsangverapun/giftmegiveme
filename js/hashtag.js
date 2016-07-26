var numadded = 0;
var subStringHashTag="";
var hashtagID = 0;

$(document).ready(function(){
	$("#hashtag").keypress(function (e) {
		if (e.which == 13) {
			var hashtagStr = document.getElementById("hashtag").value;
			var hashtags = document.getElementById("hashtaglist");

			var check = new RegExp("^[a-zA-Z0-9ก-๙]+$");
			if (!check.test(hashtagStr)) {
				alert("Invalid data in hashtag field");
				return false;
			}

			$('.hashtagList').append('<span class="tags" id="each-'+hashtagID+'"><span class="hashtagName">#<em>'+hashtagStr+ 
									 '</em></span><img src="img/close-left-20.png" class="remove" /></span><span> </span>');
			hashtagID++;
			subStringHashTag += "#" + hashtagStr;
			document.getElementById("hashtag").value = "";
			document.getElementById("hashtagSend").value = subStringHashTag;
			return false;
		}
	});
	$('.remove').livequery('click', function() {
		
		var hashtagID = $(this).parent().attr('id').replace('each-','');
		var hashtagName = $('#each-'+hashtagID).children(".hashtagName").find('em').html();
		$(this).parent().remove();
		var hashtagStr = $('.hashtaglist').text();
		document.getElementById("hashtagSend").value = hashtagStr;
	});
});


function doReset() {
  numadded=0;
  var hashtags = document.getElementById("hashtaglist");
    hashtags.value="";
    hashtags.appendChild("");
}