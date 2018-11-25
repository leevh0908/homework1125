package cn.com.taiji.serives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.taiji.bean.Boy;

@Service
public class Helloserives {
	@Value("sjhaf")
private String adress;
@Autowired
private Boy boy;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Helloserives(String adress) {
		super();
		this.adress = adress;
	}

	public Helloserives() {
		super();
	}

	@Override
	public String toString() {
		return "Helloserives [adress=" + adress + "]";
	}
	
}
