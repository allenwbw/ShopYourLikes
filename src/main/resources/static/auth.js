 var JWT;
$("#loginForm").submit(function(event) {
    event.preventDefault();
    var $form = $(this);
    var username = $form.find("input[name='username']").val();
    var password = $form.find("input[name='password']").val();
    console.log("retreived\n");
    console.log(username);
    console.log(password);
    formdata = {"username":username,"password":password};
    $.ajax({
        url: "/login",
        type: "POST",
        data: JSON.stringify(formdata),
        contentType: "application/json; charset=utf-8"
        
    }).done(function (data, textStatus, xhr) {
        JWT = xhr.getResponseHeader('Authorization').substring(7);
        $.ajax({
            url: "/dashboard",
            type: "GET",
            beforeSend: function(xhr) {xhr.setRequestHeader('Authorization',JWT)}
        }).done(function (data) {$('.container').empty().append(data);});
    });   
});
$("a.nav").click(function(event) {
    event.preventDefault();
    var url = $(this).attr('href');
    $.ajax({
        url: url,
        type: "GET",
        beforeSend: function(xhr) {xhr.setRequestHeader('Authorization',JWT)}
    }).done(function (data) {$('div.container').empty().append(data);});
});