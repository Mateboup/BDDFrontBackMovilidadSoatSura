package co.com.segurossura.certification.soat.utils;

public final class ScriptConstantes {

  public static final String ACTIVAR_EXPEDIR =
      "window.opener.jQuery(\"input:radio[name=radio_Accion][value=EX]\").removeAttr(\"disabled\"), window.opener.jQuery(\"input:radio[name=radio_Accion][value=EX]\").css(\"display\",\"inline\"),window.opener.jQuery(\"input:radio[name=radio_Accion][value=EX]\").parent().css(\"display\",\"inline\"),window.opener.jQuery(\"#formExpedicion\\\\:boton_Enviar\").removeAttr(\"disabled\"),window.opener.jQuery(\"#formExpedicion\\\\:boton_Enviar\").css(\"display\",\"inline\")";

  private ScriptConstantes() {}
}
