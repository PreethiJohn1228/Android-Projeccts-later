using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MVCDemoProject.Models
{
    public class LoginModel
    {
        [Required(ErrorMessage ="This field is required")]
        
        public string Username { get; set; }

        [Required(ErrorMessage = "This field is required")]
        [DataType(DataType.Password)]
        
        public string Password { get; set; }

        [Required(ErrorMessage = "This field is required")]
        [EmailAddress(ErrorMessage ="Invalid email address")]
        public string Email { get; set; }
    
    }
}
