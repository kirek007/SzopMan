package pl.edu.pjwstk.shopMan.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SkinBean {

	@ManagedProperty(value="blueSky")
    private String skin;


    public String getSkin() {

        return skin;
    }

    public void setSkin(String skin) {

        this.skin = skin;
    }

}