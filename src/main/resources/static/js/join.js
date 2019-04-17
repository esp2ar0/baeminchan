function $(selector) {
    return document.querySelector(selector);
}

document.addEventListener("DOMContentLoaded", () => {
    initEvents();
})

function initEvents() {
    const joinBtn = $(".btn.btn_mint.btn_big");
    joinBtn.addEventListener("click", registerJoinHandler);
}

function fetchManager({url, method, body, headers}) {
    fetch(url, {method, body, headers, credentials: "same-origin"})
        .then((response) => {
            if(response.status == '201') {
                location.replace('login');
                alert("회원가입이 정상적으로 처리됐습니다.");
            }
            console.log(response);
    });
}

function registerJoinHandler(evt) {
    evt.preventDefault();

    const emailId = $("#email_id").value;
    const emailDomain = $("#email_domain").value;
    if(!isValidEmail(emailId, emailDomain)) return;

    const password = $("#pw1").value;
    const password2 = $("#pw2").value;
    if(!isValidPassword(password, password2)) return;

    const name = $("#name").value;
    const cell1 = $("#cell1").value;
    const cell2 = $("#cell2").value;
    const cell3 = $("#cell3").value;

    fetchManager({
        url: '/api/members',
        method: 'POST',
        headers: {'content-type': 'application/json'},
        body: JSON.stringify({emailId, emailDomain, password, name, cell1, cell2, cell3}),
    })
}

function isValidEmail(emailId, emailDomain) {
    if(emailId == "" || emailDomain == "") {
        $("#email_caution").style.display = 'inline';
        return false;
    }
    $("#email_caution").style.display = 'none';
    return true;
}

function isValidPassword(password, password2) {
    if(password !== password2) {
        $("#join_check_password2").style.display = 'inline';
        return false;
    }
    $("#join_check_password2").style.display = 'none';
    return true;
}

function goNext(element, length, target) {
    if(element.value.length == length) {
        $("#" + target).focus();
    }
}