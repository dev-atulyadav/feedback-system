const buttons = document.querySelectorAll("button");
const forms = document.querySelectorAll(".forms-container");
const anchors = document.querySelectorAll("a");
const close_btns = document.querySelectorAll(".close-btn");

function showForm(e) {
  e.preventDefault();
  let form;
  let text = e.target.textContent;
  if (text === "Share Now" || text === "Login" || text === "student") {
    form = forms[0];
    form.style.display = "flex";
    forms[1].style.display = "none";
  } else if (text === "admin") {
    form = forms[1];
    form.style.display = "flex";
    forms[0].style.display = "none";
  }
}
function closeForm(e) {
  e.preventDefault();
  for (const form of forms) {
    form.style.display = "none";
  }
}
buttons[0].addEventListener("click", showForm);
buttons[2].addEventListener("click", showForm);
anchors[0].addEventListener("click", showForm);
anchors[1].addEventListener("click", showForm);

for (const close_btn of close_btns) {
  close_btn.addEventListener("click", closeForm);
}
