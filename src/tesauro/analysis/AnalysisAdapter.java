/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.analysis;

import java.util.*;
import tesauro.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPrograma(APrograma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABloco(ABloco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDeclaracao(AVarDeclaracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstanteDeclaracao(AConstanteDeclaracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstAttDeclaracao(AConstAttDeclaracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASymbolTipo(ASymbolTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealTipo(ARealTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntegerTipo(AIntegerTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACompostoTipo(ACompostoTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASymValor(ASymValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealValor(ARealValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntValor(AIntValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringValor(AStringValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACmdSemCmdCmd(ACmdSemCmdCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDoCmd(AIctDoCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDoElseCmd(AIctDoElseCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIterationCmdCmd(AIterationCmdCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoCmd(ABlocoCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACmdSemCmdCmdNoShortIct(ACmdSemCmdCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDoElseNoIfCmdNoShortIct(AIctDoElseNoIfCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIterationCmdNoIfCmdNoShortIct(AIterationCmdNoIfCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoCmdNoShortIct(ABlocoCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAttVarCmdSemCmd(AAttVarCmdSemCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAttConstCmdSemCmd(AAttConstCmdSemCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACaptureCmdSemCmd(ACaptureCmdSemCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAShowCmdSemCmd(AShowCmdSemCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDo(AIctDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDoElse(AIctDoElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIctDoElseNoShortIct(AIctDoElseNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAsLongAsIterationCmd(AAsLongAsIterationCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConsideringIterationCmd(AConsideringIterationCmd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAsLongAsIterationCmdNoShortIct(AAsLongAsIterationCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConsideringIterationCmdNoShortIct(AConsideringIterationCmdNoShortIct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrExp(AOrExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndExp(AAndExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAXorExp(AXorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIgualExp(AIgualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADiffExp(ADiffExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMaiorExp(AMaiorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorExp(AMenorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMaiorIExp(AMaiorIExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorIExp(AMenorIExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASumExp(ASumExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusExp(AMinusExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultExp(AMultExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivExp(ADivExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModExp(AModExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASymValExp(ASymValExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealValExp(ARealValExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntValExp(AIntValExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASymVecValExp(ASymVecValExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinUnExp(AMinUnExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotExp(ANotExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarExp(AVarExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCode(TCode node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSymbol(TSymbol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReal(TReal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInteger(TInteger node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStart(TStart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFinish(TFinish node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVector(TVector node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConst(TConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInCaseThat(TInCaseThat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAsLongAs(TAsLongAs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConsidering(TConsidering node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTShow(TShow node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCapture(TCapture node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDo(TDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFrom(TFrom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTo(TTo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBy(TBy node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSymVal(TSymVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSymVecVal(TSymVecVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRealVal(TRealVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntVal(TIntVal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMod(TMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenor(TMenor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaior(TMaior node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMaiorI(TMaiorI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMenorI(TMenorI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgual(TIgual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiff(TDiff node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAtt(TAtt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAttConst(TAttConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTXor(TXor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLColch(TLColch node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRColch(TRColch node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLChav(TLChav node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRChav(TRChav node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPV(TPV node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
