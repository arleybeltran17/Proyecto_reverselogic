
const email = /^[a-zA-Z0-9._%+-]+@gmail\.com$/
const pass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;

const form = document.getElementById("frmValidacion");
console.log(form);

const feedbackEmail = document.querySelector('#InputEmail .feedback')
const feedbackPass = document.querySelector('#InputPass .feedback')

form.correo.addEventListener('input', e => {
    e.preventDefault();
  
    if (email.test(e.target.value)) {
      // Pasa la validación
      form.correo.setAttribute("class", "success");
      feedbackEmail.style.display = 'none';
      feedbackEmail.style.visibility = "hidden";
      feedbackEmail.style.opacity = "0";
    } else {
      // No pasa la validación
      form.correo.setAttribute("class", "error");
      feedbackEmail.style.visibility = "visible";
      feedbackEmail.style.display = 'block';
      feedbackEmail.style.color = 'black';
      feedbackEmail.style.opacity = "1";
      feedbackEmail.textContent = "tiene que ser un correo valido";
    }
  });

  
  //validacion de la contraseña 
  
  form.pass.addEventListener('input', e => {
    e.preventDefault();
  
    if (pass.test(e.target.value)) {
      // Pasa la validación
      form.pass.setAttribute("class", "success");
      feedbackPass.style.display = 'none';
      feedbackPass.style.visibility = "hidden";
      feedbackPass.style.opacity = "0";
    } else {
      // No pasa la validación
      form.pass.setAttribute("class", "error");
      feedbackPass.style.visibility = "visible";
      feedbackPass.style.display = 'block';
      feedbackPass.style.color = 'black';
      feedbackPass.style.opacity = "1";
      feedbackPass.textContent = "Solo se permite una contraseña con mayusculas, minusculas,numero o caracteres especiales";
    }
  });

  form.addEventListener('submit', e=>{
    e.preventDefault()
    if (!email.test(form.correo.value)) {
        form.correo.setAttribute("class", "error");
        return;
      }
    
      // Validar contraseña
      if (!pass.test(form.pass.value)) {
        form.pass.setAttribute("class", "error");
        return;
      }else{
        form.submit();
      }
    
  })
  