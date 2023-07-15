using MVCDemoProject.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemoProject.Controllers
{
    public class SecondpageController : Controller
    {
        // GET: Secondpage
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult _UserInfoPartial()
        {
            return PartialView();
        }
        public ActionResult Finalpage()
        {
            return View();
        }
        private string connectionString = "Data Source=xc-db-int2019.cweclpjrmoc6.us-east-1.rds.amazonaws.com,1357;Initial Catalog=XTRACHEF_Freshers;User ID=xcdbAppUser;Password=GJGwAWjB7C2tSSad65NO;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Register(UserInfoModel model)
        {
            if (ModelState.IsValid)
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    string query = "SELECT EMPLOYEE_PHONENUMBER,EMPLOYEE_ADDRESS,EMPLOYEE_AGE FROM XTRACHEF_EMPLOYEE_DETAILS WHERE EMPLOYEE_PHONENUMBER=@Phonenumber AND EMPLOYEE_ADDRESS=@Address AND EMPLOYEE_AGE=@Age";
                    SqlCommand cmd = new SqlCommand(query, conn);
                    cmd.Parameters.AddWithValue("@Phonenumber", model.PhoneNumber);
                    cmd.Parameters.AddWithValue("@Address", model.Address);
                    cmd.Parameters.AddWithValue("@Age", model.Age);
                    conn.Open();
                    SqlDataReader reader = cmd.ExecuteReader();
                    if (reader.HasRows)
                    {
                        return RedirectToAction("Finalpage", "Secondpage");
                    }
                    else
                    {
                        return RedirectToAction("AnotherPage", "Account");
                    }
                    reader.Close();
                }
            }
            else
            {
                return RedirectToAction("AnotherPage", "Account");
            }
        }
    }
}