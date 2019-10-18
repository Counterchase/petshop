package br.com.petshop.bean;

import br.com.petshop.model.ServicoAgenda;
import br.com.petshop.repository.ServicoAgendas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named
@ViewScoped
public class ServicoAgendaBean implements Serializable{
    @Inject
    private ServicoAgendas servicos;
    private List<ServicoAgenda> listaDeServicos;
    private List<ServicoAgenda> valoresGrafico;
    private BarChartModel modeloBar;
    private PieChartModel modeloPie;
    
    public void gerarRelatorio(){
        
    }
    
    public void relatorioDeServicos(){
        listaDeServicos = servicos.pesquisarTodos();
        valoresGrafico = servicos.pesquisarValoresGrafico();
    }
    
    public List<ServicoAgenda> getListaDeServicos(){
        return listaDeServicos;
    }

    public BarChartModel getModeloBar() {
        return modeloBar;
    }

    public void setModeloBar(BarChartModel modeloBar) {
        this.modeloBar = modeloBar;
    }

    public PieChartModel getModeloPie() {
        return modeloPie;
    }

    public void setModeloPie(PieChartModel modeloPie) {
        this.modeloPie = modeloPie;
    }

    public List<ServicoAgenda> getValoresGrafico() {
        return valoresGrafico;
    }
    
    public void renderizarGrafico(){
        this.modeloBar = new BarChartModel();
        getCriarModelo();
    }

    private void getCriarModelo() {
        ChartSeries mod = new ChartSeries("Faturamento");
        for (int i = 0; i < valoresGrafico.size(); i++) {
            ServicoAgenda sa = new ServicoAgenda(valoresGrafico.get(i).getServico(), valoresGrafico.get(i).getValor());
            System.out.println("serviço: "+sa.getServico()+ " - valor: "+sa.getValor());
            
            mod.set(sa.getServico(), sa.getValor());
        }
        this.modeloBar.addSeries(mod);
    }
}
