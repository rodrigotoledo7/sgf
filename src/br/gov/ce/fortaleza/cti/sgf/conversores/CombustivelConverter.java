/**
 * 
 */
package br.gov.ce.fortaleza.cti.sgf.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.gov.ce.fortaleza.cti.sgf.bean.CombustivelBean;
import br.gov.ce.fortaleza.cti.sgf.entity.TipoCombustivel;
import br.gov.ce.fortaleza.cti.sgf.service.TipoCombustivelService;
import br.gov.ce.fortaleza.cti.sgf.util.JSFUtil;

/**
 * @author Deivid
 * @since 11/12/09
 */
public class CombustivelConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.equals("")){
			CombustivelBean combustivelBean = (CombustivelBean) JSFUtil.getInstance().getSessionBean("combustivelBean");
			TipoCombustivelService combustivelService = combustivelBean.getService();
			TipoCombustivel combustivel = combustivelService.retrieve(new Integer(str));
			return combustivel;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || obj.equals("")){
			return null;
		}else{
			TipoCombustivel tipoCombustivel = (TipoCombustivel) obj;
			return String.valueOf(tipoCombustivel.getId());
		}
	}

}
