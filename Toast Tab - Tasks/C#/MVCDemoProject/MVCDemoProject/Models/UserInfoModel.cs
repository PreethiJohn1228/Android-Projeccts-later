using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MVCDemoProject.Models
{
    public class UserInfoModel
    {
        [Required(ErrorMessage = "Please enter a phone number")]
        public string PhoneNumber { get; set; }

        [Required(ErrorMessage = "Please enter an address")]
        public string Address { get; set; }
        [Required]
        [Range(10.00,50.00)]
        public int Age { get; set; }
    }
}