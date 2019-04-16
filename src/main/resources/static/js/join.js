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
                location.href = 'login.html';
            }
            console.log(response);
    });
}

function registerJoinHandler(evt) {
    evt.preventDefault();

    const emailId = $("#email_id").value;
    const emailDomain = $("#email_domain").value;
    // TODO : 이메일 양식 확인..

    const password = $("#pw1").value;
    const pw2 = $("#pw2").value;

    if(password !== pw2) {
        $("#join_check_password2").style.display = 'inline';
        return;
    } else {
        $("#join_check_password2").style.display = 'none';
    }

    const name = $("#name").value;
    const cell1 = $("#cell1").value;
    const cell2 = $("#cell2").value;
    const cell3 = $("#cell3").value;

    // TODO : goNext 구현, 데이터베이스 - mysql 연동

    fetchManager({
        url: '/api/members',
        method: 'POST',
        headers: {'content-type': 'application/json'},
        body: JSON.stringify({emailId, emailDomain, password, name, cell1, cell2, cell3}),
    })
}