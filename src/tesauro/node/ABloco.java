/* This file was generated by SableCC (http://www.sablecc.org/). */

package tesauro.node;

import java.util.*;
import tesauro.analysis.*;

@SuppressWarnings("nls")
public final class ABloco extends PBloco
{
    private final LinkedList<PDeclaracao> _declaracao_ = new LinkedList<PDeclaracao>();
    private final LinkedList<PCmd> _cmd_ = new LinkedList<PCmd>();

    public ABloco()
    {
        // Constructor
    }

    public ABloco(
        @SuppressWarnings("hiding") List<?> _declaracao_,
        @SuppressWarnings("hiding") List<?> _cmd_)
    {
        // Constructor
        setDeclaracao(_declaracao_);

        setCmd(_cmd_);

    }

    @Override
    public Object clone()
    {
        return new ABloco(
            cloneList(this._declaracao_),
            cloneList(this._cmd_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABloco(this);
    }

    public LinkedList<PDeclaracao> getDeclaracao()
    {
        return this._declaracao_;
    }

    public void setDeclaracao(List<?> list)
    {
        for(PDeclaracao e : this._declaracao_)
        {
            e.parent(null);
        }
        this._declaracao_.clear();

        for(Object obj_e : list)
        {
            PDeclaracao e = (PDeclaracao) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._declaracao_.add(e);
        }
    }

    public LinkedList<PCmd> getCmd()
    {
        return this._cmd_;
    }

    public void setCmd(List<?> list)
    {
        for(PCmd e : this._cmd_)
        {
            e.parent(null);
        }
        this._cmd_.clear();

        for(Object obj_e : list)
        {
            PCmd e = (PCmd) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._cmd_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._declaracao_)
            + toString(this._cmd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._declaracao_.remove(child))
        {
            return;
        }

        if(this._cmd_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PDeclaracao> i = this._declaracao_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PDeclaracao) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PCmd> i = this._cmd_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PCmd) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}