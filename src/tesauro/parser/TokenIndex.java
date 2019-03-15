/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.parser;

import tesauro.node.*;
import tesauro.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTCode(@SuppressWarnings("unused") TCode node)
    {
        this.index = 0;
    }

    @Override
    public void caseTSymbol(@SuppressWarnings("unused") TSymbol node)
    {
        this.index = 1;
    }

    @Override
    public void caseTReal(@SuppressWarnings("unused") TReal node)
    {
        this.index = 2;
    }

    @Override
    public void caseTInteger(@SuppressWarnings("unused") TInteger node)
    {
        this.index = 3;
    }

    @Override
    public void caseTStart(@SuppressWarnings("unused") TStart node)
    {
        this.index = 4;
    }

    @Override
    public void caseTFinish(@SuppressWarnings("unused") TFinish node)
    {
        this.index = 5;
    }

    @Override
    public void caseTVector(@SuppressWarnings("unused") TVector node)
    {
        this.index = 6;
    }

    @Override
    public void caseTConst(@SuppressWarnings("unused") TConst node)
    {
        this.index = 7;
    }

    @Override
    public void caseTInCaseThat(@SuppressWarnings("unused") TInCaseThat node)
    {
        this.index = 8;
    }

    @Override
    public void caseTAsLongAs(@SuppressWarnings("unused") TAsLongAs node)
    {
        this.index = 9;
    }

    @Override
    public void caseTConsidering(@SuppressWarnings("unused") TConsidering node)
    {
        this.index = 10;
    }

    @Override
    public void caseTShow(@SuppressWarnings("unused") TShow node)
    {
        this.index = 11;
    }

    @Override
    public void caseTCapture(@SuppressWarnings("unused") TCapture node)
    {
        this.index = 12;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 13;
    }

    @Override
    public void caseTDo(@SuppressWarnings("unused") TDo node)
    {
        this.index = 14;
    }

    @Override
    public void caseTFrom(@SuppressWarnings("unused") TFrom node)
    {
        this.index = 15;
    }

    @Override
    public void caseTTo(@SuppressWarnings("unused") TTo node)
    {
        this.index = 16;
    }

    @Override
    public void caseTBy(@SuppressWarnings("unused") TBy node)
    {
        this.index = 17;
    }

    @Override
    public void caseTSymVal(@SuppressWarnings("unused") TSymVal node)
    {
        this.index = 18;
    }

    @Override
    public void caseTSymVecVal(@SuppressWarnings("unused") TSymVecVal node)
    {
        this.index = 19;
    }

    @Override
    public void caseTRealVal(@SuppressWarnings("unused") TRealVal node)
    {
        this.index = 20;
    }

    @Override
    public void caseTIntVal(@SuppressWarnings("unused") TIntVal node)
    {
        this.index = 21;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 22;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 23;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 24;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 25;
    }

    @Override
    public void caseTMod(@SuppressWarnings("unused") TMod node)
    {
        this.index = 26;
    }

    @Override
    public void caseTMenor(@SuppressWarnings("unused") TMenor node)
    {
        this.index = 27;
    }

    @Override
    public void caseTMaior(@SuppressWarnings("unused") TMaior node)
    {
        this.index = 28;
    }

    @Override
    public void caseTMaiorI(@SuppressWarnings("unused") TMaiorI node)
    {
        this.index = 29;
    }

    @Override
    public void caseTMenorI(@SuppressWarnings("unused") TMenorI node)
    {
        this.index = 30;
    }

    @Override
    public void caseTIgual(@SuppressWarnings("unused") TIgual node)
    {
        this.index = 31;
    }

    @Override
    public void caseTDiff(@SuppressWarnings("unused") TDiff node)
    {
        this.index = 32;
    }

    @Override
    public void caseTAtt(@SuppressWarnings("unused") TAtt node)
    {
        this.index = 33;
    }

    @Override
    public void caseTAttConst(@SuppressWarnings("unused") TAttConst node)
    {
        this.index = 34;
    }

    @Override
    public void caseTNot(@SuppressWarnings("unused") TNot node)
    {
        this.index = 35;
    }

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 36;
    }

    @Override
    public void caseTOr(@SuppressWarnings("unused") TOr node)
    {
        this.index = 37;
    }

    @Override
    public void caseTXor(@SuppressWarnings("unused") TXor node)
    {
        this.index = 38;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 39;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 40;
    }

    @Override
    public void caseTLColch(@SuppressWarnings("unused") TLColch node)
    {
        this.index = 41;
    }

    @Override
    public void caseTRColch(@SuppressWarnings("unused") TRColch node)
    {
        this.index = 42;
    }

    @Override
    public void caseTLChav(@SuppressWarnings("unused") TLChav node)
    {
        this.index = 43;
    }

    @Override
    public void caseTRChav(@SuppressWarnings("unused") TRChav node)
    {
        this.index = 44;
    }

    @Override
    public void caseTPV(@SuppressWarnings("unused") TPV node)
    {
        this.index = 45;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 46;
    }

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 47;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 48;
    }
}