const text =/[A-Za-z Á-Úá-úñÑ]{3,20}/;
const pass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;


const form = document.getElementById("frmValidacion");
console.log(form);

const feedbackNombre= document.querySelector('#inputUsername .feedback')
const feedbackPass= document.querySelector('#inputPassword .feedback')


// Validación del nombre
form.inputUsername.addEventListener('input', (e) => {
  e.preventDefault();

  if (text.test(e.target.value)) {
    // Pasa la validación
    form.inputUsername.setAttribute("class", "success");
    feedbackNombre.style.display = 'none';
    feedbackNombre.style.visibility = "hidden";
    feedbackNombre.style.opacity = "0";
  } else {
    // No pasa la validación
    form.inputUsername.setAttribute("class", "error");
    feedbackNombre.style.visibility = "visible";
    feedbackNombre.style.display = 'block';
    feedbackNombre.style.color = 'black';
    feedbackNombre.style.opacity = "1";
    feedbackNombre.textContent = "solo puede tener letras de 1 a 10";
  }
});

//validacion de la contraseña

form.inputPassword.addEventListener('input', e => {
  e.preventDefault();

  if (pass.test(e.target.value)) {
    // Pasa la validación
    form.inputPassword.setAttribute("class", "success");
    feedbackPass.style.display = 'none';
    feedbackPass.style.visibility = "hidden";
    feedbackPass.style.opacity = "0";
  } else {
    // No pasa la validación
    form.inputPassword.setAttribute("class", "error");
    feedbackPass.style.visibility = "visible";
    feedbackPass.style.display = 'block';
    feedbackPass.style.color = 'black';
    feedbackPass.style.opacity = "1";
    feedbackPass.textContent = "Solo se permite una contraseña con mayusculas, minusculas,numero o caracteres especiales";
  }



});
