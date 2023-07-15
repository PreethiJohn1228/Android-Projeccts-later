using MVCDemoProject.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemoProject.Controllers
{
    public class AccountController : Controller
    {
        public ActionResult Login()
        {
            return View(new LoginModel());
        }
        public ActionResult AnotherPage()
        {
            return View();
        }
        public ActionResult Welcome()
        {
            return View();
        }
        public ActionResult _LoginPartial()
        {
            return PartialView();
        }
        private string connectionString = "Data Source=xc-db-int2019.cweclpjrmoc6.us-east-1.rds.amazonaws.com,1357;Initial Catalog=XTRACHEF_Freshers;User ID=xcdbAppUser;Password=GJGwAWjB7C2tSSad65NO;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel model)
        {
            if (ModelState.IsValid)
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    string query = "SELECT EMPLOYEE_USERNAME,EMPLOYEE_PASSWORD,EMPLOYEE_EMAIL FROM XTRACHEF_EMPLOYEE_DETAILS WHERE EMPLOYEE_USERNAME=@Username AND EMPLOYEE_PASSWORD=@Password AND EMPLOYEE_EMAIL=@EMAIL";
                    SqlCommand cmd = new SqlCommand(query, conn);
                    cmd.Parameters.AddWithValue("@Username", model.Username);
                    cmd.Parameters.AddWithValue("@Password", model.Password);
                    cmd.Parameters.AddWithValue("@Email", model.Email);
                    conn.Open();
                    SqlDataReader reader = cmd.ExecuteReader();
                    if (reader.HasRows)
                    {
                        return RedirectToAction("AnotherPage", "Account");
                    }
                    else
                    {
                        return RedirectToAction("Index", "Home");
                    }
                    reader.Close();
                }
            }
            else
            {
                return RedirectToAction("Index", "Home");
            }
        }
    }
}
