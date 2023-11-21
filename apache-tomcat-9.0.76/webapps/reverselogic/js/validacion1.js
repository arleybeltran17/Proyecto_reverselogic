const text =/[A-Za-z Á-Úá-úñÑ]{3,20}/;
const pass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
const number = /^[0-2]{1,2}$/;


const form = document.getElementById("frmValidacion1");
console.log(form);

const feedbackNombre= document.querySelector('#Usu_Nombre .feedback')
const feedbackPass= document.querySelector('#Usu_Password .feedback')
const feedbackRol= document.querySelector('#Usu_Rol .feedback')


// Validación del nombre
form.contlabel.addEventListener('input', (e) => {
  e.preventDefault();

  if (text.test(e.target.value)) {
    // Pasa la validación
    form.contlabel.setAttribute("class", "success");
    feedbackNombre.style.display = 'none';
    feedbackNombre.style.visibility = "hidden";
    feedbackNombre.style.opacity = "0";
  } else {
    // No pasa la validación
    form.contlabel.setAttribute("class", "error");
    feedbackNombre.style.visibility = "visible";
    feedbackNombre.style.display = 'block';
    feedbackNombre.style.color = 'black';
    feedbackNombre.style.opacity = "1";
    feedbackNombre.textContent = "solo puede tener letras de 1 a 10";
  }
});

//validacion de la contraseña

form.contlabel2.addEventListener('input', e => {
  e.preventDefault();

  if (pass.test(e.target.value)) {
    // Pasa la validación
    form.contlabel2.setAttribute("class", "success");
    feedbackPass.style.display = 'none';
    feedbackPass.style.visibility = "hidden";
    feedbackPass.style.opacity = "0";
  } else {
    // No pasa la validación
    form.contlabel2.setAttribute("class", "error");
    feedbackPass.style.visibility = "visible";
    feedbackPass.style.display = 'block';
    feedbackPass.style.color = 'black';
    feedbackPass.style.opacity = "1";
    feedbackPass.textContent = "Solo se permite una contraseña con mayusculas, minusculas,numero o caracteres especiales";
  }



});

form.contlabel1.addEventListener('input', e => {
    e.preventDefault();
  
    if (number.test(e.target.value)) {
      // Pasa la validación
      form.contlabel1.setAttribute("class", "success");
      feedbackRol.style.display = 'none';
      feedbackRol.style.visibility = "hidden";
      feedbackPass.style.opacity = "0";
    } else {
      // No pasa la validación
      form.contlabel1.setAttribute("class", "error");
      feedbackRol.style.visibility = "visible";
      feedbackRol.style.display = 'block';
      feedbackRol.style.color = 'black';
      feedbackRol.style.opacity = "1";
      feedbackRol.textContent = "Solo se permite roles 1 y 2";
    }
  
  
  
  })
