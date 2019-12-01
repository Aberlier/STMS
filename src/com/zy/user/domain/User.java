package com.zy.user.domain;

public class User {
	
		//对应数据库
		private int uid;//主键
		private String loginname;//用户名
		private String loginpass;//登录密码
		private String email;//邮箱
		private boolean status;//状态，ture表示已激活否则未激活
		private String activationCode;//激活码，它是唯一值，即每个用户的激活码是不同的
		private int totlogin;//记录登录次数
		private String role;
		//注册表单
		private String reloginpass;//确认密码
		private String verifyCode;//验证码
		
		//修改密码表单
		private String newpass;//新密码

		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public String getLoginname() {
			return loginname;
		}

		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}

		public String getLoginpass() {
			return loginpass;
		}

		public void setLoginpass(String loginpass) {
			this.loginpass = loginpass;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public String getActivationCode() {
			return activationCode;
		}

		public void setActivationCode(String activationCode) {
			this.activationCode = activationCode;
		}

		public int getTotlogin() {
			return totlogin;
		}

		public void setTotlogin(int totlogin) {
			this.totlogin = totlogin;
		}

		public String getReloginpass() {
			return reloginpass;
		}

		public void setReloginpass(String reloginpass) {
			this.reloginpass = reloginpass;
		}

		public String getVerifyCode() {
			return verifyCode;
		}

		public void setVerifyCode(String verifyCode) {
			this.verifyCode = verifyCode;
		}

		public String getNewpass() {
			return newpass;
		}

		public void setNewpass(String newpass) {
			this.newpass = newpass;
		}
		
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [uid=" + uid + ", loginname=" + loginname
					+ ", loginpass=" + loginpass + ", email=" + email
					+", role=" + role+ ", status=" + status + ", activationCode="
					+ activationCode + ", totlogin=" + totlogin
					+ ", reloginpass=" + reloginpass + ", verifyCode="
					+ verifyCode + ", newpass=" + newpass + "]";
		}

	}
