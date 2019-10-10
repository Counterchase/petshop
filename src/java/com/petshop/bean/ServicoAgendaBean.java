package com.petshop.bean;

import com.petshop.model.ServicoAgenda;
import com.petshop.repository.ServicoAgendas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named
@RequestScoped
public class ServicoAgendaBean implements Serializable {

    @Inject
    private ServicoAgendas servicos;

    private List<ServicoAgenda> listaDeServicos;
    private List<ServicoAgenda> valoresGrafico;

    private BarChartModel modeloBar;

    public void relatorioDeServicos() {
        listaDeServicos = servicos.pesquisarTodos();
        valoresGrafico = servicos.pesquisarValoresGrafico();
    }

    public void renderizarGrafico() {
        this.modeloBar = new BarChartModel();
        getCriarModelo();
    }

    public BarChartModel getModeloBar() {
        return modeloBar;
    }

    public List<ServicoAgenda> getListaDeServicos() {
        return listaDeServicos;
    }

    public List<ServicoAgenda> getValoresGrafico() {
        return valoresGrafico;
    }

    private void getCriarModelo() {
        ChartSeries mod = new ChartSeries("Faturamento");
        for (int i = 0; i < valoresGrafico.size(); i++) {
            ServicoAgenda sa = new ServicoAgenda(valoresGrafico.get(i).getServico(),
                                                  valoresGrafico.get(i).getValor());
            mod.set(sa.getServico(), sa.getValor());
        }
        this.modeloBar.addSeries(mod);
    }

}
