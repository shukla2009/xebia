package com.assign.xebia;

public enum Status {
	OVERWEIGHT {
		@Override
		public String toString() {
			return "Overweight";
		}
	},
	LOWBATTERY {
		@Override
		public String toString() {
			return "Low Battery";
		}
	},
	OVERCAPACITY {
		@Override
		public String toString() {
			return "Over Capacity";
		}
	},
	SCANFAILURE {
		@Override
		public String toString() {
			return "Scan Failure";
		}
	},
	OK{
		@Override
		public String toString() {
			return "ok";
		}
	}
	
}
