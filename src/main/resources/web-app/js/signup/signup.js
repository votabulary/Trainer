$(document).ready(function(){
  $("#contactform").submit(function(e) {
    var userData = new User($(this).serializeArray());
    var postBody = userData.postBody();
    MemberAPI.post(postBody);
    e.preventDefault(); //STOP default action
//    e.unbind(); //unbind. to stop multiple form submit.
  });
  $("#btnSubmit").click(function(){
    $("#contactform").submit();
  });
});

var MemberAPI = {
	post: function(body) {
        var strBody = JSON.stringify(body);
		$.ajax({
		  type: "POST",
		  url: "/members",
		  contentType: "application/json; charset=utf-8",
		  data: strBody,
		  success: function (data, textStatus, jqXhr) {
		  	var user = User.fromJson(data);
		  	alert("Created user with ID: " + user.id);
		  },
		  dataType: "json"
		})
		.fail(function(jqXhr, textStatus, errorThrown) {
			alert("Fail: " + errorThrown + ": " + jqXhr.responseText);
		});
	}
}